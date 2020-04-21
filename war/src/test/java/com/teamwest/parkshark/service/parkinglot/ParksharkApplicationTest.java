package com.teamwest.parkshark.service.parkinglot;

import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParksharkApplicationTest {

    @Test
    void springBootTestContext() {
    }

    @Test
    public void ResponseCodeForParkingLotIsCorrect() throws IOException
    {
        HttpUriRequest request = new HttpGet("http://localhost:8080/parkinglot");
        StatusLine statusLine = HttpClientBuilder.create().build().execute(request).getStatusLine();
        System.out.println(statusLine.getStatusCode());
        assertEquals(HttpStatus.SC_OK, statusLine.getStatusCode());
    }

    @Test
    public void ResponsCodeForParkingLotIsDummyDummyTest() throws  IOException{
        HttpUriRequest request = new HttpGet("http://localhost:8080/parkinglot");
        String contentType = (Arrays.toString(HttpClientBuilder.create().build().execute(request).getFirstHeader("Content-Type").getElements()));
        assertEquals(contentType, "[application/json]");
    }

}