package com.teamwest.parkshark.api.parkinglot;

import com.teamwest.parkshark.service.parkinglot.CreateParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.ParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.ParkinglotMinimalDto;
import com.teamwest.parkshark.service.parkinglot.ParkinglotService;
import com.teamwest.parkshark.service.parkingspot.PSallocationDto;
import com.teamwest.parkshark.service.parkingspot.ParkingSpotAllocationService;
import com.teamwest.parkshark.service.parkingspot.StartPSallocationDto;
import com.teamwest.parkshark.service.parkingspot.StopPSallocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "parkinglots")
public class ParkinglotController {

    ParkinglotService parkinglotService;
    ParkingSpotAllocationService parkingSpotAllocationService;

    @Autowired
    public ParkinglotController(ParkinglotService parkinglotService, ParkingSpotAllocationService parkingSpotAllocationService) {
        this.parkinglotService = parkinglotService;
        this.parkingSpotAllocationService = parkingSpotAllocationService;
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

    @PostMapping(consumes="application/json", produces="application/json", path = "{id}/startPSA")
    @ResponseStatus(HttpStatus.CREATED)
    public PSallocationDto startParkingSpotAllocation(@RequestBody StartPSallocationDto startPSallocationDto, @PathVariable(name = "id") int parkinglotID){
        return parkingSpotAllocationService.startPSallocation(startPSallocationDto,parkinglotID);
    }

    @PostMapping(consumes="application/json", produces="application/json", path = "stopPSA")
    @ResponseStatus(HttpStatus.CREATED)
    public PSallocationDto stopParkingSpotAllocation(@RequestBody StopPSallocationDto stopPSallocationDto){
        return parkingSpotAllocationService.stopPSallocation(stopPSallocationDto);
    }

    @GetMapping(produces = "application/json", path="/parkingspots")
    public List<PSallocationDto> getAllParkingLotAllocations(){
        return parkingSpotAllocationService.getAllParkingLotAllocations();
    }
}
