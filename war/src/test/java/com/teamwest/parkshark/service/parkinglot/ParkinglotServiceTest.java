//package com.teamwest.parkshark.service.parkinglot;
//
//import com.teamwest.parkshark.domain.parkinglot.Parkinglot;
//import com.teamwest.parkshark.domain.parkinglot.ParkinglotCategory;
//import com.teamwest.parkshark.infrastructure.employee.EmployeeRepository;
//import com.teamwest.parkshark.infrastructure.parkinglot.ParkinglotRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//import static com.teamwest.parkshark.domain.parkinglot.ParkinglotCategory.UNDERGROUND_BUILDING;
//
//@SpringBootTest
//@EnableAutoConfiguration
//public class ParkinglotServiceTest {
//
//   @Autowired
//   private ParkinglotRepository parkinglotRepository;
//
//   @Autowired
//   private ParkinglotMapper parkinglotMapper;
//
//
//    @Autowired
//    ParkinglotService parkinglotService;
//
//   @Test
//   void contextTest(){
//        Assertions.assertThat(true).isEqualTo(true);
//    }
//
//
//
//    @Test
//    void createParkingLotTest() {
//        CreateParkinglotDto createParkinglotDto = new CreateParkinglotDto( "Bram Vm", UNDERGROUND_BUILDING, 100, 1, "straat",74,2531, "Antwerpen", 5.5);
//        ParkinglotDto parkinglotDtoTest = new ParkinglotDto(1, "Bram Vm", UNDERGROUND_BUILDING, 100, 1, "straat",74,2531, "Antwerpen", 5.5);
//        ParkinglotDto parkinglotDto = parkinglotService.createParkingLot(createParkinglotDto);
//        Assertions.assertThat(parkinglotDto).isEqualTo(parkinglotDtoTest);
//    }
//}