package com.teamwest.parkshark.api.division;

import com.teamwest.parkshark.service.division.dtos.CreateDivisionDto;
import com.teamwest.parkshark.service.division.dtos.DivisionDto;
import com.teamwest.parkshark.service.member.dtos.EmployeeDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DivisionControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void createDivision_whenDivisionNotValid_returnStatus400(){
        WebTestClient.ResponseSpec response = this.webTestClient.post()
                .uri("/divisions")
                .contentType(MediaType.APPLICATION_JSON)
                .exchange();
        response.expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @Sql(statements = "insert into employee (id, name) values (1, 'Jan Janssens')")
    void createDivision_whenDivisionIsValid_returnStatus201(){
        //given
        CreateDivisionDto createDivisionDto = new CreateDivisionDto("Apple", "Google", 0, 1);

        WebTestClient.ResponseSpec response = this.webTestClient.post()
                .uri("/divisions")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(createDivisionDto), CreateDivisionDto.class)
                .exchange();
        response.expectStatus().isEqualTo(HttpStatus.CREATED);
    }


    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Sql(statements = "insert into employee (id, name) values (1, 'Jan Janssens')")
    void createDivision_whenDirectorNotValid_returnStatus400(){
        //given
        CreateDivisionDto createDivisionDto = new CreateDivisionDto("Apple", "Google", 0, 2);

        WebTestClient.ResponseSpec response = this.webTestClient.post()
                .uri("/divisions")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(createDivisionDto), CreateDivisionDto.class)
                .exchange();
        response.expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }


    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Sql(statements = "insert into employee (id, name) values (1, 'Jan Janssens')")
    void createDivision_whenDivisionIsValid_returnDivisionDto(){
        //given
        CreateDivisionDto createDivisionDto = new CreateDivisionDto("Apple", "Google", 0, 1);

        WebTestClient.ResponseSpec response = this.webTestClient.post()
                .uri("/divisions")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(createDivisionDto), CreateDivisionDto.class)
                .exchange();

        DivisionDto result = response
                .expectBody(DivisionDto.class)
                .returnResult()
                .getResponseBody();

        DivisionDto expected = new DivisionDto(
                0,
                "Apple",
                "Google",
                null,
                new EmployeeDto(1, "Jan Janssens", null, null, null, null) );

        Assertions.assertThat(result).isEqualTo(expected);
    }



//    @Test
//    void registerMember_whenMemberIsNotValid_returnStatus400() {
//        WebTestClient.ResponseSpec response = this.webTestClient.post()
//                .uri("/members")
//                .contentType(MediaType.APPLICATION_JSON)
//                .exchange();
//        response.expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
//    }

}