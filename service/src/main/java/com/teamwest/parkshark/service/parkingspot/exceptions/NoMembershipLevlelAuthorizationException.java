package com.teamwest.parkshark.service.parkingspot.exceptions;

public class NoMembershipLevlelAuthorizationException extends RuntimeException {
    public NoMembershipLevlelAuthorizationException(String message) {
        super("The member has no right to perform this action based on the membership level: ");
    }
}
