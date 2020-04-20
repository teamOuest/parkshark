package com.teamwest.parkshark.infrastructure.employee;

import com.teamwest.parkshark.domain.member.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
