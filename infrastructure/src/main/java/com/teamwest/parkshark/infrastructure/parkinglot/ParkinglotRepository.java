package com.teamwest.parkshark.infrastructure.parkinglot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkinglotRepository extends CrudRepository<ParkinglotRepository,Long> {

}
