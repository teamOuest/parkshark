package com.teamwest.parkshark.service.member.Exceptions;

public class NoEmployeeFoundException extends RuntimeException {

    public NoEmployeeFoundException(String message) {
        super(message);
    }
}
