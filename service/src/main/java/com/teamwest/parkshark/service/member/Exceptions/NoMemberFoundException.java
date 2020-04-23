package com.teamwest.parkshark.service.member.Exceptions;

public class NoMemberFoundException extends RuntimeException {
    public NoMemberFoundException(String message) {
        super(message);
    }
}
