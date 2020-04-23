package com.teamwest.parkshark.api.parkinglot;

import com.teamwest.parkshark.service.member.Exceptions.NoMemberFoundException;
import com.teamwest.parkshark.service.parkinglot.Exceptions.IDnotFoundException;
import com.teamwest.parkshark.service.parkingspot.exceptions.AllocationAlreadyStoppedException;
import com.teamwest.parkshark.service.parkingspot.exceptions.NoAllocationFoundException;
import com.teamwest.parkshark.service.parkingspot.exceptions.NoMembershipLevlelAuthorizationException;
import com.teamwest.parkshark.service.parkingspot.exceptions.NoParkingSpotsLeftException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ParkinglotExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ParkinglotExceptionHandler.class);

    @ExceptionHandler(EmptyResultDataAccessException.class)
    protected void couldNotFind(EmptyResultDataAccessException exception, HttpServletResponse response) throws IOException {
        logger.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(NoAllocationFoundException.class)
    protected void noAllocationFound(NoAllocationFoundException exception, HttpServletResponse response) throws IOException {
        logger.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(AllocationAlreadyStoppedException.class)
    protected void noAllocationFound(AllocationAlreadyStoppedException exception, HttpServletResponse response) throws IOException {
        logger.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(NoParkingSpotsLeftException.class)
    protected void noAllocationFound(NoParkingSpotsLeftException exception, HttpServletResponse response) throws IOException {
        logger.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(IDnotFoundException.class)
    protected void noAllocationFound(IDnotFoundException exception, HttpServletResponse response) throws IOException {
        logger.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(NoMemberFoundException.class)
    protected void noAllocationFound(NoMemberFoundException exception, HttpServletResponse response) throws IOException {
        logger.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(NoMembershipLevlelAuthorizationException.class)
    protected void noAllocationFound(NoMembershipLevlelAuthorizationException exception, HttpServletResponse response) throws IOException {
        logger.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }




}
