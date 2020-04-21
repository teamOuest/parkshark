//package com.teamwest.parkshark.api.parkinglot;
//
//import com.teamwest.parkshark.service.parkinglot.CreateParkinglotDto;
//import com.teamwest.parkshark.service.parkinglot.ParkinglotDto;
//import com.teamwest.parkshark.service.parkinglot.ParkinglotService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import reactor.core.publisher.Mono;
//
//import static com.teamwest.parkshark.domain.parkinglot.ParkinglotCategory.ABOVE_GROUND_BUILDING;
//
//@WithMockUser
//@ExtendWith(SpringExtension.class)
//@WebFluxTest(controllers = ParkinglotController.class)
//@Import(Config.class)
//class ParkinglotControllerTest2 {
//    @MockBean
//    ParkinglotService parkinglotService;
//
//    @Autowired
//    private WebTestClient client;
//
//    @Test
//    void ParkinglotControllerWebrequestTest() {
//        CreateParkinglotDto createParkinglotDto = new CreateParkinglotDto(
//                "name",
//                ABOVE_GROUND_BUILDING,
//                150,
//                1,
//                "street",
//                1,
//                123,
//                "city",
//                12.5);
//
//        ParkinglotDto parkinglotDto = new ParkinglotDto(
//                111,
//                "name",
//                ABOVE_GROUND_BUILDING,
//                150,
//                1,
//                "street",
//                1,
//                123,
//                "city",
//                12.5);
//
//        Mockito
//                .when(parkinglotService.createParkingLot(ArgumentMatchers.any()))
//                .thenReturn(parkinglotDto);
//        String url = "/parkinglot";
//
//
//        client
//                .post()
//                .uri(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(Mono.just(createParkinglotDto),CreateParkinglotDto.class)
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isCreated();
//    }
//
//}