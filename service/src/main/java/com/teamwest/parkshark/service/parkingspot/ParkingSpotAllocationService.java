package com.teamwest.parkshark.service.parkingspot;


import com.teamwest.parkshark.domain.member.MembershipLevel;
import com.teamwest.parkshark.domain.parkinglot.Parkinglot;
import com.teamwest.parkshark.domain.parkingspot.ParkingSpotAllocation;
import com.teamwest.parkshark.infrastructure.member.MemberRepository;
import com.teamwest.parkshark.infrastructure.parkinglot.ParkinglotRepository;
import com.teamwest.parkshark.infrastructure.parkingspot.ParkingSpotAllocationRepository;
import com.teamwest.parkshark.service.parkinglot.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    public PSallocationDto startPSallocation(StartPSallocationDto startPSallocationDto,int parkinglotID) {
        assertMemberExists(startPSallocationDto);
        assertParkinlotExists(parkinglotID);
        checkIfLicensePlateCanDiffer(startPSallocationDto);
        ParkingSpotAllocation psa = psAllocationMapper.toParkingSpotAllocation(startPSallocationDto,parkinglotID);
        updateParkingLotRepository(parkinglotID);
        return psAllocationMapper.toPSallocationDto(psAllocationRepository.save(psa));


    }

    private void updateParkingLotRepository(int parkinglotID) {
        if (!parkinglotService.newParkingSpotAllocation(parkinglotID)) throw new IllegalArgumentException(); //TODO Custom error
    }

    private boolean assertParkinlotExists(int parkinglotID) {
        parkinglotRepository.findById(parkinglotID).orElseThrow(IllegalArgumentException::new); //TODO custom exception
        return true;
    }


    private boolean assertMemberExists(StartPSallocationDto startPSallocationDto) {
        int memberID = startPSallocationDto.getMemberID();
        memberRepository.findById(memberID).orElseThrow(IllegalArgumentException::new); //TODO custom exception
        return true;
    }

    private void checkIfLicensePlateCanDiffer(StartPSallocationDto startPSallocationDto) {
        if (!assertGoldMembershipLevel(startPSallocationDto) && !assertLicenseplateCorrespondsToMember(startPSallocationDto) ){
            throw new IllegalArgumentException("Licence plate");
        }


    }

    private boolean assertGoldMembershipLevel(StartPSallocationDto startPSallocationDto) {
        int memberID = startPSallocationDto.getMemberID();
        MembershipLevel membershipLevel = memberRepository.findById(memberID).get().getMembershipLevel();
        if (membershipLevel == MembershipLevel.GOLD) return true;
        return false;
    }

    private boolean assertLicenseplateCorrespondsToMember(StartPSallocationDto startPSallocationDto){
        int memberID = startPSallocationDto.getMemberID();
        String memberLicensePlate = memberRepository.findById(memberID).get().getLicensePlate();
        String givenLicensePlate = startPSallocationDto.getLicensePlate();
        return memberLicensePlate.equals(givenLicensePlate);
    }
}
