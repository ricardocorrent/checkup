package com.checkup.server.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DuplicateTopicException extends RequestException {

    public DuplicateTopicException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }

    public DuplicateTopicException(final Exception e) {
        super(e.getCause(), HttpStatus.UNPROCESSABLE_ENTITY.value());
    }

}
