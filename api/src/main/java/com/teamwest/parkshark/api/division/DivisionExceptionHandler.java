package com.teamwest.parkshark.api.division;

import com.teamwest.parkshark.service.member.Exceptions.NoEmployeeFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class DivisionExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(DivisionExceptionHandler.class);

    @ExceptionHandler(NoEmployeeFoundException.class)
    protected void duplicateEntry(NoEmployeeFoundException exception, HttpServletResponse response) throws IOException {
        logger.info(exception.getMessage(), exception);
        response.sendError(BAD_REQUEST.value(),  exception.getMessage());
    }
}
