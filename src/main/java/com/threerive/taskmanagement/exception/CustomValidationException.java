package com.threerive.taskmanagement.exception;

public class CustomValidationException extends RuntimeException{
    public CustomValidationException() {
        super();
    }

    public CustomValidationException(String s) {
        super(s);
    }
}
