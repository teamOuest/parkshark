package com.teamwest.parkshark.service.division;

import com.teamwest.parkshark.domain.division.Division;
import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.Employee;
import com.teamwest.parkshark.domain.member.PhoneNumber;
import com.teamwest.parkshark.domain.member.PostCode;
import com.teamwest.parkshark.infrastructure.division.DivisionRepository;
import com.teamwest.parkshark.infrastructure.employee.EmployeeRepository;
import com.teamwest.parkshark.service.division.dtos.CreateDivisionDto;
import com.teamwest.parkshark.service.division.dtos.DivisionDto;
import com.teamwest.parkshark.service.member.dtos.EmployeeDto;
import com.teamwest.parkshark.service.member.EmployeeMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DivisionServiceTest {

    @Mock
    DivisionRepository divisionRepository;

    @Mock
    EmployeeRepository employeeRepository;

    DivisionMapper divisionMapper;

    @Test
    void createDivision_ifValidDivision_returnsCorrectDto() {
        //given
        CreateDivisionDto createDivisionDto = new CreateDivisionDto("ColruytGroup",
                "Switchfully",
                0,
                1);

        when(divisionRepository.findById(0)).thenReturn(Optional.empty());

        Employee employee = new Employee("Test",
                new PhoneNumber(32,
                        489354392),
                new PhoneNumber(32,
                        23568463),
                "tombellens@hotmail.com",
                new Address("Diestsestraat",
                        15,
                        new PostCode(3000,
                                "Leuven")));
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        DivisionMapper divisionMapper = new DivisionMapper(new EmployeeMapper());
        DivisionService divisionService = new DivisionService(divisionMapper, divisionRepository, employeeRepository);

        DivisionDto expectedDivisionDto = new DivisionDto(0, "ColruytGroup",
                "Switchfully",
                null,
                new EmployeeDto(0, "Test",
                        new PhoneNumber(32, 489354392),
                        new PhoneNumber(32, 23568463),
                        "tombellens@hotmail.com",
                        new Address("Diestsestraat", 15, new PostCode(3000, "Leuven"))));

        Division divisionToCreate = divisionMapper.createDivisionDtoToDivision(createDivisionDto, null, employee);
        when(divisionRepository.save(any(Division.class))).thenReturn(divisionToCreate);

        //when
        DivisionDto resultDivisionDto = divisionService.createDivision(createDivisionDto);

        //then
        Assertions.assertThat(resultDivisionDto).isEqualTo(expectedDivisionDto);
    }


}