package com.example.springvalidator.exception;

public class ParameterException extends RuntimeException {
    String code;

    public ParameterException() {
        super();
    }
    public ParameterException(String code, String message) {
        super(message);
        this.code = code;
    }
}
