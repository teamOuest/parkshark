package com.teamwest.parkshark.service.parkinglot;

import com.teamwest.parkshark.domain.parkinglot.Parkinglot;
import com.teamwest.parkshark.infrastructure.parkinglot.ParkinglotRepository;
import com.teamwest.parkshark.service.parkinglot.Exceptions.IDnotFoundException;
import com.teamwest.parkshark.service.parkinglot.dtos.CreateParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.dtos.ParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.dtos.ParkinglotMinimalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkinglotService {

    ParkinglotRepository parkinglotRepository;
    ParkinglotMapper parkinglotMapper;

    @Autowired
    public ParkinglotService(ParkinglotRepository parkinglotRepository, ParkinglotMapper parkinglotMapper) {
        this.parkinglotRepository = parkinglotRepository;
        this.parkinglotMapper = parkinglotMapper;
    }

    public ParkinglotDto createParkingLot(CreateParkinglotDto createParkinglotDto) {
        Parkinglot newParkinglot = parkinglotMapper.toParkinglot(createParkinglotDto);
        Parkinglot savedParkinglot = parkinglotRepository.save(newParkinglot);
        return getCreationResponse(savedParkinglot);
    }

    private ParkinglotDto getCreationResponse(Parkinglot savedParkinglot) {
        int parkingLotID = savedParkinglot.getId();
        savedParkinglot = parkinglotRepository
                .findById(parkingLotID)
                .orElseThrow(() -> new IDnotFoundException(parkingLotID));

        return parkinglotMapper.toParkinglotDto(savedParkinglot);
    }

    public List<ParkinglotMinimalDto> getAllParkingLots() {
        List<Parkinglot> parkingLots = new ArrayList<>();
//        parkinglotRepository.findAll().forEach(parkingLots::add);
        parkinglotRepository.findAllByOrderByIdAsc().forEach(parkingLots::add);
        return parkinglotMapper.toParkinglotMinimalDto(parkingLots);
    }

    public boolean newParkingSpotAllocation(int parkingLotId){
        Parkinglot parkinglotToUpdate = parkinglotRepository.findById(parkingLotId)
                .orElseThrow(() -> new IllegalArgumentException());
        if (parkinglotToUpdate.getAvailableCapacity() <= 0) return false;
        parkinglotToUpdate.setAvailableCapacity(parkinglotToUpdate.getAvailableCapacity() - 1);
        parkinglotRepository.save(parkinglotToUpdate);
        return true;
    }

    public boolean stopParkingSpotAllocation(int parkingLotId){
        Parkinglot parkinglotToUpdate = parkinglotRepository.findById(parkingLotId)
                .orElseThrow(() -> new IllegalArgumentException());
        parkinglotToUpdate.setAvailableCapacity(parkinglotToUpdate.getAvailableCapacity() + 1);
        parkinglotRepository.save(parkinglotToUpdate);
        return true;
    }

    public ParkinglotMinimalDto getParkingLotById(int parkinglotID) {
        Parkinglot parkinglot = parkinglotRepository.findById(parkinglotID).get();
        return parkinglotMapper.toParkinglotMinimalDto(parkinglot);
    }
}
