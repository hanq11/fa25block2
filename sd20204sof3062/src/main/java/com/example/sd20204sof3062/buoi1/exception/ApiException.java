package com.example.sd20204sof3062.buoi1.exception;

public class ApiException extends RuntimeException {
    private final String code;

    public ApiException(String message, String code) {
        super(message);
        this.code = code;
    }
}
