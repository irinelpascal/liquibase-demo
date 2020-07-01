package com.example.liquibasedemo.exception;

public class CustomException extends RuntimeException {

    private String message;

    public String getMessage() {
        return message;
    }

    public CustomException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public CustomException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    protected CustomException() {
    }
}
