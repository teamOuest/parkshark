package com.teamwest.parkshark.api.parkinglot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamwest.parkshark.infrastructure.parkinglot.ParkinglotRepository;
import com.teamwest.parkshark.service.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParkinglotControllerTest {

//    @Autowired
//    private MemberService memberService;

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private ParkinglotRepository parkinglotRepository;


    @Test
    void checkIfSpringBootIsCorrectlyConfigured() {
        // This test will fail when there are 'obvious' problems with the Spring application context, like a missing bean.
    }


}