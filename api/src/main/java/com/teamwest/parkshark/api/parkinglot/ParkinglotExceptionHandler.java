package com.teamwest.parkshark.api.parkinglot;

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

}
