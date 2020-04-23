package com.teamwest.parkshark.service.parkingspot.exceptions;

public class NoAllocationFoundException extends RuntimeException{

    public NoAllocationFoundException(String message) {
        super(message);
    }
}
