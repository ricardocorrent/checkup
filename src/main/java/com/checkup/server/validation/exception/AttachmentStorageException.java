package com.checkup.server.validation.exception;

public class AttachmentStorageException extends RuntimeException {

    public AttachmentStorageException(final String message) {
        super(message);
    }

    public AttachmentStorageException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
