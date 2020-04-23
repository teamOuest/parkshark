package com.teamwest.parkshark.service.parkingspot;


import com.sun.xml.bind.v2.model.core.ID;
import com.teamwest.parkshark.domain.member.MembershipLevel;
import com.teamwest.parkshark.domain.parkingspot.ParkingSpotAllocation;
import com.teamwest.parkshark.infrastructure.member.MemberRepository;
import com.teamwest.parkshark.infrastructure.parkinglot.ParkinglotRepository;
import com.teamwest.parkshark.infrastructure.parkingspot.ParkingSpotAllocationRepository;
import com.teamwest.parkshark.service.member.Exceptions.NoMemberFoundException;
import com.teamwest.parkshark.service.parkinglot.Exceptions.IDnotFoundException;
import com.teamwest.parkshark.service.parkinglot.ParkinglotService;
import com.teamwest.parkshark.service.parkingspot.exceptions.AllocationAlreadyStoppedException;
import com.teamwest.parkshark.service.parkingspot.exceptions.NoAllocationFoundException;
import com.teamwest.parkshark.service.parkingspot.exceptions.NoMembershipLevlelAuthorizationException;
import com.teamwest.parkshark.service.parkingspot.exceptions.NoParkingSpotsLeftException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingSpotAllocationService {


    ParkingSpotAllocationRepository psAllocationRepository;

    MemberRepository memberRepository;
    ParkingSpotAllocationMapper psAllocationMapper;
    ParkinglotRepository parkinglotRepository;
    ParkinglotService parkinglotService;


    @Autowired
    public ParkingSpotAllocationService(ParkingSpotAllocationRepository psAllocationRepository, MemberRepository memberRepository, ParkingSpotAllocationMapper psAllocationMapper, ParkinglotRepository parkinglotRepository, ParkinglotService parkinglotService) {
        this.psAllocationRepository = psAllocationRepository;
        this.memberRepository = memberRepository;
        this.psAllocationMapper = psAllocationMapper;
        this.parkinglotRepository = parkinglotRepository;
        this.parkinglotService = parkinglotService;
    }


    public PSallocationDto startPSallocation(StartPSallocationDto startPSallocationDto, int parkinglotID) {
        checkBasicAssertions(startPSallocationDto, parkinglotID);

        ParkingSpotAllocation psa = psAllocationMapper.toParkingSpotAllocation(startPSallocationDto, parkinglotID);
        updateParkingLotAvailableCapacity(parkinglotID);
        psAllocationRepository.save(psa);

        return saveResponse(psa);
    }

    public PSallocationDto stopPSallocation(StopPSallocationDto stopPSallocationDto) {
        checkIfPSAllocationIsValid(stopPSallocationDto);
        ParkingSpotAllocation parkingSpotAllocation = psAllocationRepository.findById(stopPSallocationDto.getId())
                .orElse(null);

        parkingSpotAllocation.setEndTime(LocalDateTime.now());
        parkingSpotAllocation.setStatusIsActive(false);
        parkinglotService.stopParkingSpotAllocation(parkingSpotAllocation.getParkinglotID());

        return psAllocationMapper.toPSallocationDto(psAllocationRepository.save(parkingSpotAllocation));
    }

    private void checkIfPSAllocationIsValid(StopPSallocationDto stopPSallocationDto) {
        ParkingSpotAllocation parkingSpotAllocation = psAllocationRepository.findById(stopPSallocationDto.getId())
                .orElseThrow(() -> new NoAllocationFoundException("No PSAllocation with that id"));
        if (!parkingSpotAllocation.isStatusIsActive())
            throw new AllocationAlreadyStoppedException("This allocation was already stopped at " + parkingSpotAllocation.getEndTime());
    }

    private PSallocationDto saveResponse(ParkingSpotAllocation psa) {
        return psAllocationMapper.toPSallocationDto(
                psAllocationRepository.findById(
                        psa.getId())
                        .get());
    }

    private void updateParkingLotAvailableCapacity(int parkinglotID) {
        if (!parkinglotService.newParkingSpotAllocation(parkinglotID))
            throw new NoParkingSpotsLeftException("There are no parking spots left in parking with id " + parkinglotID);
    }

    private void checkBasicAssertions(StartPSallocationDto dto, int parkinglotID) {
        assertMemberExists(dto);
        assertParkinlotExists(parkinglotID);
        checkIfLicensePlateCanDiffer(dto);
    }

    private boolean assertParkinlotExists(int parkinglotID) {
        parkinglotRepository.findById(parkinglotID).orElseThrow(() -> new IDnotFoundException(parkinglotID));
        return true;
    }

    private boolean assertMemberExists(StartPSallocationDto startPSallocationDto) {
        int memberID = startPSallocationDto.getMemberID();
        memberRepository.findById(memberID).orElseThrow(() -> new NoMemberFoundException("No member with the id: " + memberID));
        return true;
    }

    private void checkIfLicensePlateCanDiffer(StartPSallocationDto startPSallocationDto) {
        if (!assertGoldMembershipLevel(startPSallocationDto) && !assertLicenseplateCorrespondsToMember(startPSallocationDto)) {
            throw new NoMembershipLevlelAuthorizationException("only gold members can add different licence plates than their own");
        }
    }

    private boolean assertGoldMembershipLevel(StartPSallocationDto startPSallocationDto) {
        int memberID = startPSallocationDto.getMemberID();
        MembershipLevel membershipLevel = memberRepository.findById(memberID).get().getMembershipLevel();
        if (membershipLevel == MembershipLevel.GOLD) return true;
        return false;
    }

    private boolean assertLicenseplateCorrespondsToMember(StartPSallocationDto startPSallocationDto) {
        int memberID = startPSallocationDto.getMemberID();
        String memberLicensePlate = memberRepository.findById(memberID).get().getLicensePlate();
        String givenLicensePlate = startPSallocationDto.getLicensePlate();
        return memberLicensePlate.equals(givenLicensePlate);
    }

    public List<PSallocationDto> getAllParkingLotAllocations() {
        List<ParkingSpotAllocation> parkingSpotAllocations = new ArrayList<>();
        psAllocationRepository.findAllByOrderByStartTime().forEach(parkingSpotAllocations::add);
        return psAllocationMapper.toPSallocationDto(parkingSpotAllocations);
    }
}
