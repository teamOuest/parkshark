package com.teamwest.parkshark.service.parkinglot;

import com.teamwest.parkshark.domain.parkinglot.Parkinglot;
import com.teamwest.parkshark.infrastructure.parkinglot.ParkinglotRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkinglotService {

    ParkinglotRepository parkinglotRepository;
    ParkinglotMapper parkinglotMapper;

    public ParkinglotService(ParkinglotRepository parkinglotRepository, ParkinglotMapper parkinglotMapper) {
        this.parkinglotRepository = parkinglotRepository;
        this.parkinglotMapper = parkinglotMapper;
    }

    public ParkinglotDto createParkingLot(CreateParkinglotDto createParkinglotDto){
        Parkinglot newParkinglot = parkinglotMapper.createParkinglotDtoToParkinglot(createParkinglotDto);
        Parkinglot savedParkinglot = parkinglotRepository.save(newParkinglot);
        return parkinglotMapper.parkinglotToParkinglotDto);
    }
}
