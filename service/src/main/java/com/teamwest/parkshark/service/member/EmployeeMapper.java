package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.domain.member.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {


    public EmployeeDto employeeToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getMobilePhoneNumber(),
                employee.getLandlinePhoneNumber(),
                employee.getEmail(),
                employee.getAddress()
        );
    }
}
