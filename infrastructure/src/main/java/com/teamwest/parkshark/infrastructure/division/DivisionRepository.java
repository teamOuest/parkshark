package com.teamwest.parkshark.infrastructure.division;

import com.teamwest.parkshark.domain.division.Division;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DivisionRepository extends CrudRepository<Division, Integer> {
}
