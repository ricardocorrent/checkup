package com.checkup.image;

public class DocumentStorageException extends RuntimeException {

    public DocumentStorageException(final String message) {
        super(message);
    }

    public DocumentStorageException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
