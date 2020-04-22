package com.teamwest.parkshark.api.parkinglot;

import com.teamwest.parkshark.service.parkinglot.CreateParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.ParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.ParkinglotMinimalDto;
import com.teamwest.parkshark.service.parkinglot.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "parkinglot")
public class ParkinglotController {

    ParkinglotService parkinglotService;

    @Autowired
    public ParkinglotController(ParkinglotService parkinglotService) {
        this.parkinglotService = parkinglotService;
    }

    @PostMapping(consumes="application/json", produces="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkinglotDto createParkinglot(@RequestBody CreateParkinglotDto createParkinglotDto){
        return parkinglotService.createParkingLot(createParkinglotDto);
    }

    @GetMapping(produces="application/json")
    public List<ParkinglotMinimalDto> getAllParkingLots(){
        return parkinglotService.getAllParkingLots();
    }
}
