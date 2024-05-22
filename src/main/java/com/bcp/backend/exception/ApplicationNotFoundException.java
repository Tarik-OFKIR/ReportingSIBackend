package com.bcp.backend.exception;

public class ApplicationNotFoundException extends Exception {
    public ApplicationNotFoundException(String message) {
        super(message);
    }
}
