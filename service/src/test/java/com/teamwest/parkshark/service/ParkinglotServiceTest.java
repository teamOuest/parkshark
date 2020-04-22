package com.teamwest.parkshark.service;

import com.teamwest.parkshark.domain.Price;
import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.Employee;
import com.teamwest.parkshark.domain.member.PostCode;
import com.teamwest.parkshark.domain.parkinglot.Parkinglot;
import com.teamwest.parkshark.infrastructure.employee.EmployeeRepository;
import com.teamwest.parkshark.infrastructure.parkinglot.ParkinglotRepository;
import com.teamwest.parkshark.service.parkinglot.CreateParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.ParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.ParkinglotMapper;
import com.teamwest.parkshark.service.parkinglot.ParkinglotService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.teamwest.parkshark.domain.parkinglot.ParkinglotCategory.UNDERGROUND_BUILDING;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParkinglotServiceTest {

   @Mock
   private ParkinglotRepository parkinglotRepository;

   @Mock
   private EmployeeRepository employeeRepository;

   @Mock
   private ParkinglotMapper parkinglotMapper;

    @InjectMocks
    ParkinglotService parkinglotService;

    CreateParkinglotDto createParkinglotDto;
    ParkinglotDto parkinglotDtoTest;
    Parkinglot parkinglot;

    @Mock
    Employee employee;


    @BeforeEach
    void setUp() {
        createParkinglotDto = new CreateParkinglotDto( "Bram Vm", UNDERGROUND_BUILDING, 100, 1, "straat",74,2531, "Antwerpen", 5.5);
        parkinglotDtoTest = new ParkinglotDto(1, "Bram Vm", UNDERGROUND_BUILDING, 100, 1, "straat",74,2531, "Antwerpen", 5.5,100);
        parkinglot = new Parkinglot("Bram Vm", UNDERGROUND_BUILDING, 100, employee, new Address("straat",74,new PostCode(2531,"Antwerpen")), new Price(5.5,"EURO"),100);

    }

    @Test
    void createParkingLotTest() {
        when(parkinglotRepository.save(parkinglot)).thenReturn(parkinglot);
        when(parkinglotRepository.findById(parkinglot.getId())).thenReturn(Optional.of(parkinglot));
        when(parkinglotMapper.toParkinglot(createParkinglotDto)).thenReturn(parkinglot);
        when(parkinglotMapper.toParkinglotDto(parkinglot)).thenReturn(parkinglotDtoTest);


        Assertions
                .assertThat(parkinglotService.createParkingLot(createParkinglotDto))
                .isEqualTo(parkinglotDtoTest);
    }
}