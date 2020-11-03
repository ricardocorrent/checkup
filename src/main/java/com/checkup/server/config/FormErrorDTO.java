package com.checkup.server.config;

public class FormErrorDTO {

    private String field;
    private String error;

    public FormErrorDTO(final String field, final String errorMessage) {
        this.field = field;
        this.error = errorMessage;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
