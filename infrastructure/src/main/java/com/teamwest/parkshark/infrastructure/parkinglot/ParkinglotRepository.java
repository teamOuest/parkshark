package com.teamwest.parkshark.infrastructure.parkinglot;

import com.teamwest.parkshark.domain.parkinglot.Parkinglot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkinglotRepository extends CrudRepository<Parkinglot,Long> {

}
