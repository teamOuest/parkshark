package com.teamwest.parkshark.service.parkingspot;

import com.teamwest.parkshark.domain.parkingspot.ParkingSpotAllocation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<PSallocationDto> toPSallocationDto(List<ParkingSpotAllocation> parkingSpotAllocations) {
        return parkingSpotAllocations.stream()
                                    .map((parkingSpotAllocation) ->toPSallocationDto(parkingSpotAllocation))
                                    .collect(Collectors.toList());

    }
}