package com.teamwest.parkshark.service.parkingspot;

import com.teamwest.parkshark.domain.parkingspot.ParkingSpotAllocation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ParkingSpotAllocationMapper {


    public ParkingSpotAllocation toParkingSpotAllocation(StartPSallocationDto startPSallocationDto, int parkinlotID){
        return new ParkingSpotAllocation(
                startPSallocationDto.getMemberID(),
                startPSallocationDto.getLicensePlate(),
                parkinlotID, LocalDateTime.now(),null,true);

    }
}
