package com.teamwest.parkshark.infrastructure.parkinglot;

import com.teamwest.parkshark.domain.parkinglot.Parkinglot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ParkinglotRepository extends CrudRepository<Parkinglot,Long> {

}
