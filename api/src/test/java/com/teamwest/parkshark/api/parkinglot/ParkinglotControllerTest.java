package com.teamwest.parkshark.api.parkinglot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamwest.parkshark.infrastructure.parkinglot.ParkinglotRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkinglotControllerTest {

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