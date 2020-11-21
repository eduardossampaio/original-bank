package com.esampaio.orig.api.rest;

public class DefaultSuccessResponse {

    private String message;

    public DefaultSuccessResponse() {
    }

    public DefaultSuccessResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
