package com.teamwest.parkshark.service.division;

import com.teamwest.parkshark.domain.division.Division;
import com.teamwest.parkshark.domain.member.Employee;
import com.teamwest.parkshark.infrastructure.division.DivisionRepository;
import com.teamwest.parkshark.infrastructure.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DivisionService {

    DivisionMapper divisionMapper;
    DivisionRepository divisionRepository;
    EmployeeRepository employeeRepository;

    @Autowired
    public DivisionService(DivisionMapper divisionMapper, DivisionRepository divisionRepository, EmployeeRepository employeeRepository) {
        this.divisionMapper = divisionMapper;
        this.divisionRepository = divisionRepository;
        this.employeeRepository = employeeRepository;
    }

    public DivisionDto createDivision(CreateDivisionDto createDivisionDto){
        Division parentDivision = divisionRepository.findById(createDivisionDto.getParentDivisionId()).orElse(null);
        Employee director = employeeRepository.findById(createDivisionDto.getDirectorId()).orElse(null);
        Division division = divisionMapper.createDivisionDtoToDivision(createDivisionDto, parentDivision, director);
        Division savedDivision = divisionRepository.save(division);
        return divisionMapper.divisionToDivisionDto(savedDivision);
    }

}
