package com.checkup.server.validation.exception;

import javax.naming.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {

    public InvalidJwtAuthenticationException(final String message) {
        super(message);
    }

}
