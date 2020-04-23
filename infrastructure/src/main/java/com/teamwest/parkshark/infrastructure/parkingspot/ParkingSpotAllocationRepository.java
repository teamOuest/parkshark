package com.teamwest.parkshark.infrastructure.parkingspot;

import com.teamwest.parkshark.domain.parkingspot.ParkingSpotAllocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ParkingSpotAllocationRepository extends CrudRepository<ParkingSpotAllocation, Integer> {
}
