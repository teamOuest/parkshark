package com.teamwest.parkshark.api.parkinglot;

import com.teamwest.parkshark.service.parkinglot.dtos.CreateParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.dtos.ParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.ParkinglotService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static com.teamwest.parkshark.domain.parkinglot.ParkinglotCategory.ABOVE_GROUND_BUILDING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


class ParkinglotControllerTest {

    //TODO
    @Nested
    @SpringBootTest
    class BehaviourTests {
        @Mock
        private ParkinglotService parkinglotService;

        @InjectMocks
        private ParkinglotController parkinglotController;


        @Test
        void contextTest() {
            // This test will fail when there are 'obvious' problems with the Spring application context, like a missing bean.
        }

        @Test
        void createParkinglotBehaviourTest() {
            //Given
            CreateParkinglotDto createParkinglotDto = new CreateParkinglotDto(
                    "name",
                    ABOVE_GROUND_BUILDING,
                    150,
                    1,
                    "street",
                    1,
                    123,
                    "city",
                    12.5);
            ParkinglotDto parkinglotDto = new ParkinglotDto(
                    111,
                    "name",
                    ABOVE_GROUND_BUILDING,
                    150,
                    1,
                    "street",
                    1,
                    123,
                    "city",
                    12.5, 150);

            //When
            when(parkinglotService.createParkingLot(createParkinglotDto)).thenReturn(parkinglotDto);

            //Then
            assertThat(parkinglotController.createParkinglot(createParkinglotDto)).isEqualTo(parkinglotDto);
        }
    }

    @Nested
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @DirtiesContext
    class EndpointTests {
    }

}