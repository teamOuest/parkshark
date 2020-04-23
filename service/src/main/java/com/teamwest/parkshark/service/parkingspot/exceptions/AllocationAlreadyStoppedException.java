package com.teamwest.parkshark.service.parkingspot.exceptions;

public class AllocationAlreadyStoppedException extends RuntimeException {

    public AllocationAlreadyStoppedException(String message) {
        super(message);
    }
}
