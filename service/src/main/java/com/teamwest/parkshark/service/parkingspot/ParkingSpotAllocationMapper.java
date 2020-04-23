package com.teamwest.parkshark.service.parkingspot;

import com.teamwest.parkshark.domain.parkingspot.ParkingSpotAllocation;
import com.teamwest.parkshark.service.parkingspot.dtos.PSallocationDto;
import com.teamwest.parkshark.service.parkingspot.dtos.StartPSallocationDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ParkingSpotAllocationMapper {


    public ParkingSpotAllocation toParkingSpotAllocation(StartPSallocationDto startPSallocationDto, int parkinlotID) {
        return new ParkingSpotAllocation(
                startPSallocationDto.getMemberID(),
                startPSallocationDto.getLicensePlate(),
                parkinlotID, LocalDateTime.now(), null, true);

    }

    public PSallocationDto toPSallocationDto(ParkingSpotAllocation parkingSpotAllocation) {
        return new PSallocationDto(parkingSpotAllocation.getId(),
                parkingSpotAllocation.getMemberID(),
                parkingSpotAllocation.getLicensePlate(),
                parkingSpotAllocation.getParkinglotID(),
                parkingSpotAllocation.getStartTime(),
                parkingSpotAllocation.getEndTime(),
                parkingSpotAllocation.isStatusIsActive());
    }
}