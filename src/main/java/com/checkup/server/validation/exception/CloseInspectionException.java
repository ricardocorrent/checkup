package com.checkup.server.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CloseInspectionException extends RequestException {

    public CloseInspectionException() {
        super(HttpStatus.CONFLICT.value());
    }

}
