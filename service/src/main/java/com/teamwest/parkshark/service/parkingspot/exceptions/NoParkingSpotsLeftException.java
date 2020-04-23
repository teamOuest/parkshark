package com.teamwest.parkshark.service.parkingspot.exceptions;

public class NoParkingSpotsLeftException extends RuntimeException {

    public NoParkingSpotsLeftException(String message) {
        super(message);
    }
}
