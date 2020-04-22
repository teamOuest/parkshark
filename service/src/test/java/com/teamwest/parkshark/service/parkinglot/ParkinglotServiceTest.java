package com.teamwest.parkshark.service.parkinglot;

import com.teamwest.parkshark.infrastructure.employee.EmployeeRepository;
import com.teamwest.parkshark.infrastructure.parkinglot.ParkinglotRepository;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;



import static com.teamwest.parkshark.domain.parkinglot.ParkinglotCategory.UNDERGROUND_BUILDING;


public class ParkinglotServiceTest {

   @Mock
   private ParkinglotRepository parkinglotRepository;

   @Mock
   private EmployeeRepository employeeRepository;

    @InjectMocks
    ParkinglotService parkinglotService;

    CreateParkinglotDto createParkinglotDto;
    ParkinglotDto parkinglotDtoTest;


    @BeforeEach
    void setUp() {
        createParkinglotDto = new CreateParkinglotDto( "Bram Vm", UNDERGROUND_BUILDING, 100, 1, "straat",74,2531, "Antwerpen", 5.5);
        parkinglotDtoTest = new ParkinglotDto(1, "Bram Vm", UNDERGROUND_BUILDING, 100, 1, "straat",74,2531, "Antwerpen", 5.5);
    }

    @Test
    void createParkingLotTest() {
        System.out.println(parkinglotDtoTest.toString());
        ParkinglotDto parkinglotDto = parkinglotService.createParkingLot(createParkinglotDto);
        System.out.println(parkinglotDto.toString());
        Assertions.assertThat(parkinglotDto).isEqualTo(parkinglotDtoTest);
    }
}