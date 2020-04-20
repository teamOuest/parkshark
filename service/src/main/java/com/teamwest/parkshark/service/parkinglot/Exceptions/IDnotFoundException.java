package com.teamwest.parkshark.service.parkinglot.Exceptions;

import org.springframework.dao.EmptyResultDataAccessException;

public class IDnotFoundException extends EmptyResultDataAccessException {

    public IDnotFoundException(int id) {
        super("No results were found for ID: " +id, 1);
    }
}
