package com.teamwest.parkshark.api.member;

import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.PhoneNumber;
import com.teamwest.parkshark.domain.member.PostCode;
import com.teamwest.parkshark.service.member.CreateMemberDto;
import com.teamwest.parkshark.service.member.GetAllMemberDto;
import com.teamwest.parkshark.service.member.MemberDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
class MemberControllerTest {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void registerMember_whenMemberIsNotValid_returnStatus400() {
        WebTestClient.ResponseSpec response = this.webTestClient.post()
                .uri("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .exchange();
        response.expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }


    @Test
    void registerMember_whenValidMember_returnsStatus201() {
        //given
        CreateMemberDto createMemberDto = new CreateMemberDto(
                "Test",
                32,
                489354392,
                32,
                23568463,
                "tombellens@hotmail.com",
                "Diestsestraat",
                15,
                3000,
                "Leuven",
                "ABC123",
                LocalDate.now());

        WebTestClient.ResponseSpec response = this.webTestClient.post()
                .uri("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(createMemberDto), CreateMemberDto.class)
                .exchange();
        response.expectStatus().isEqualTo(HttpStatus.CREATED);
    }


    @Test
    void registerMember_whenValidMember_returnsMemberDto() {
        //given
        CreateMemberDto createMemberDto = new CreateMemberDto(
                "Test",
                32,
                489354392,
                32,
                23568463,
                "tombellens@hotmail.com",
                "Diestsestraat",
                15,
                3000,
                "Leuven",
                "ABC123",
                LocalDate.now());

        MemberDto expectedMemberDto = new MemberDto(
                0,
                "Test",
                new PhoneNumber(32,
                        489354392),
                new PhoneNumber(32,
                        23568463),

                new Address("Diestsestraat",
                        15,
                        new PostCode(3000,
                                "Leuven")),
                "tombellens@hotmail.com",
                "ABC123",
                LocalDate.now());

        //when
        WebTestClient.ResponseSpec response = this.webTestClient.post()
                .uri("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(createMemberDto), CreateMemberDto.class)
                .exchange();

        MemberDto result = response
                .expectBody(MemberDto.class)
                .returnResult()
                .getResponseBody();

        //then
        Assertions.assertThat(result).isEqualTo(expectedMemberDto);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    void getAllMembers_ifNoMembers_returnsEmptyList(){
        WebTestClient.ResponseSpec response = this.webTestClient.get()
                .uri("/members")
                .exchange();
        response.expectStatus().isEqualTo(HttpStatus.OK);

        List<GetAllMemberDto> result = response
                .expectBodyList(GetAllMemberDto.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertThat(result).isEmpty();
    }


    @Test
    @DirtiesContext
    void getAllMembers_returnsCorrectMembers(){
        CreateMemberDto createMemberDto1 = new CreateMemberDto(
                "Test",
                32,
                489354392,
                32,
                23568463,
                "tombellens@hotmail.com",
                "Diestsestraat",
                15,
                3000,
                "Leuven",
                "ABC123",
                LocalDate.now());
        this.webTestClient.post()
                .uri("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(createMemberDto1), CreateMemberDto.class)
                .exchange();
        GetAllMemberDto expectedgetAllMemberDto1 = new GetAllMemberDto(
                0,
                "Test",
                new PhoneNumber(32,
                        489354392),
                new PhoneNumber(32,
                        23568463),
                "tombellens@hotmail.com",
                "ABC123",
                LocalDate.now());

        CreateMemberDto createMemberDto2 = new CreateMemberDto(
                "Test2",
                32,
                489354392,
                32,
                23568463,
                "tombellen@hotmail.com",
                "Diestsestraat",
                15,
                3000,
                "Leuven",
                "ABC123",
                LocalDate.now());
        this.webTestClient.post()
                .uri("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(createMemberDto2), CreateMemberDto.class)
                .exchange();
        GetAllMemberDto expectedgetAllMemberDto2 = new GetAllMemberDto(
                0,
                "Test2",
                new PhoneNumber(32,
                        489354392),
                new PhoneNumber(32,
                        23568463),
                "tombellen@hotmail.com",
                "ABC123",
                LocalDate.now());

        WebTestClient.ResponseSpec response = this.webTestClient.get()
                .uri("/members")
                .exchange();
        response.expectStatus().isEqualTo(HttpStatus.OK);

        List<GetAllMemberDto> result = response
                .expectBodyList(GetAllMemberDto.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertThat(result).containsExactlyInAnyOrder(expectedgetAllMemberDto1, expectedgetAllMemberDto2);
    }

}