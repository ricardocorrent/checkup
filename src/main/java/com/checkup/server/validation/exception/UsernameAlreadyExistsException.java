package com.checkup.server.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsernameAlreadyExistsException extends UsernameException {

    public UsernameAlreadyExistsException(String msg, Throwable t) {
        super(msg, t);
    }

    public UsernameAlreadyExistsException(String msg) {
        super(msg);
    }

}
