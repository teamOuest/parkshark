package com.teamwest.parkshark.api.member;

import com.teamwest.parkshark.api.parkinglot.ParkinglotExceptionHandler;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class MemberExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(MemberExceptionHandler.class);

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected void duplicateEntry(DataIntegrityViolationException exception, HttpServletResponse response) throws IOException {
        logger.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(), "boodschap");
    }



}
