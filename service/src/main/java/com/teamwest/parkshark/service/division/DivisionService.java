package com.teamwest.parkshark.service.division;

import com.teamwest.parkshark.domain.division.Division;
import com.teamwest.parkshark.domain.member.Employee;
import com.teamwest.parkshark.infrastructure.division.DivisionRepository;
import com.teamwest.parkshark.infrastructure.employee.EmployeeRepository;
import com.teamwest.parkshark.service.division.dtos.CreateDivisionDto;
import com.teamwest.parkshark.service.division.dtos.DivisionDto;
import com.teamwest.parkshark.service.member.Exceptions.NoEmployeeFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Division parentDivision = divisionRepository.findById(createDivisionDto.getParentDivisionId())
                .orElse(null);
        Employee director = employeeRepository.findById(createDivisionDto.getDirectorId())
                .orElseThrow(() -> new NoEmployeeFoundException("There is no director with id " + createDivisionDto.getDirectorId() )); //TODO custom exception
        Division division = divisionMapper.createDivisionDtoToDivision(createDivisionDto, parentDivision, director);
        Division savedDivision = divisionRepository.save(division);
        return divisionMapper.divisionToDivisionDto(savedDivision);
    }

    public List<DivisionDto> getAllDivisions(){
        List<Division> divisionList = new ArrayList<>();
        divisionRepository.findAll().forEach(divisionList::add);
        return divisionList.stream().map(division -> divisionMapper.divisionToDivisionDto(division)).collect(Collectors.toList());
    }

}
