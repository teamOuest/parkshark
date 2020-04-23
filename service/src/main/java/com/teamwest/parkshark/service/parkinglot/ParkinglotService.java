package com.teamwest.parkshark.service.parkinglot;

import com.teamwest.parkshark.domain.parkinglot.Parkinglot;
import com.teamwest.parkshark.infrastructure.parkinglot.ParkinglotRepository;
import com.teamwest.parkshark.service.parkinglot.Exceptions.IDnotFoundException;
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
        parkinglotRepository.findAll().forEach(parkingLots::add);
        return parkinglotMapper.toParkinglotMinimalDto(parkingLots);
    }

    public boolean newParkingSpotAllocation(int parkingLotId) {
        return changeAvailableParkingSpots(parkingLotId, -1);
    }

    public boolean stopParkingSpotAllocation(int parkingLotId) {
        return changeAvailableParkingSpots(parkingLotId, 1);
    }

    private boolean changeAvailableParkingSpots(int parkingLotId, int capacityChange) {
        Parkinglot parkinglotToUpdate = parkinglotRepository.findById(parkingLotId)
                .orElseThrow(() -> new IllegalArgumentException());
        if (parkinglotToUpdate.getAvailableCapacity() <= 0) return false;
        parkinglotToUpdate.setAvailableCapacity(parkinglotToUpdate.getAvailableCapacity() + (capacityChange));
        parkinglotRepository.save(parkinglotToUpdate);
        return true;
    }
}
