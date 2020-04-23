package com.teamwest.parkshark.service.division;

import com.teamwest.parkshark.domain.division.Division;
import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.Employee;
import com.teamwest.parkshark.domain.member.PhoneNumber;
import com.teamwest.parkshark.domain.member.PostCode;
import com.teamwest.parkshark.service.division.dtos.DivisionDto;
import com.teamwest.parkshark.service.member.EmployeeMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DivisionMapperTest {


    @Test
    void divisionToDivisionDto_ifNoParentDivision_givesCorrectDivisionDto() {
        //given
        EmployeeMapper employeeMapper = new EmployeeMapper();
        DivisionMapper divisionMapper = new DivisionMapper(employeeMapper);

        Employee employee = new Employee(
                "John Doe",
                new PhoneNumber(33, 123),
                new PhoneNumber(34, 456),
                "john@doe.com",
                new Address("Straat", 5, new PostCode(9000, "Gent"))
        );
        Division division = new Division("Heroku",
                "Github",
                null,
                employee);

        DivisionDto expectedDto = new DivisionDto(
                0,
                "Heroku",
                "Github",
                null,
                employeeMapper.employeeToEmployeeDto(employee));

        //when
        DivisionDto resultDto = divisionMapper.divisionToDivisionDto(division);

        //then
        Assertions.assertThat(resultDto).isEqualTo(expectedDto);
    }



    @Test
    void divisionToDivisionDto_withParentDivision_givesCorrectDivisionDto() {
        //given
        EmployeeMapper employeeMapper = new EmployeeMapper();
        DivisionMapper divisionMapper = new DivisionMapper(employeeMapper);

        Employee employee = new Employee(
                "John Doe",
                new PhoneNumber(33, 123),
                new PhoneNumber(34, 456),
                "john@doe.com",
                new Address("Straat", 5, new PostCode(9000, "Gent"))
        );
        Division parentDivision = new Division("Afdeling",
                "Oude afdeling",
                null,
                employee);

        Division division = new Division("Heroku",
                "Github",
                parentDivision,
                employee);

        DivisionDto expectedDto = new DivisionDto(
                0,
                "Heroku",
                "Github",
                new DivisionDto(5,"Afdeling",
                        "Oude afdeling",
                        null,
                        employeeMapper.employeeToEmployeeDto(employee)),
                employeeMapper.employeeToEmployeeDto(employee));

        //when
        DivisionDto resultDto = divisionMapper.divisionToDivisionDto(division);

        //then
        Assertions.assertThat(resultDto).isEqualTo(expectedDto);
    }

}