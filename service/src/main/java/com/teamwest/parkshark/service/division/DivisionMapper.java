package com.teamwest.parkshark.service.division;

import com.teamwest.parkshark.domain.division.Division;
import com.teamwest.parkshark.domain.member.Employee;
import com.teamwest.parkshark.service.division.dtos.CreateDivisionDto;
import com.teamwest.parkshark.service.division.dtos.DivisionDto;
import com.teamwest.parkshark.service.member.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {

EmployeeMapper employeeMapper;

@Autowired
    public DivisionMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public Division createDivisionDtoToDivision(CreateDivisionDto createDivisionDto, Division parentDivision, Employee director) {
        return new Division(createDivisionDto.getName(),
                createDivisionDto.getOriginalName(),
                parentDivision,
                director);
    }

    public DivisionDto divisionToDivisionDto(Division savedDivision) {
        return new DivisionDto(
                savedDivision.getId(),
                savedDivision.getName(),
                savedDivision.getOriginalName(),
                savedDivision.getParentDivision()==null ? null : divisionToDivisionDto(savedDivision.getParentDivision()),
                employeeMapper.employeeToEmployeeDto(savedDivision.getDirector())
                );
    }
}
