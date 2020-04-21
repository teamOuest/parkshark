package com.teamwest.parkshark.service.member;

import javax.validation.constraints.Email;

public class EmailNotValidException extends RuntimeException{

    public EmailNotValidException(String s) {
        super(s);
    }

}
