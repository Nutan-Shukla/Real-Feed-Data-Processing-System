package com.example.Spring.exception;

public class IncorrectUserBodyException extends RuntimeException {

    public IncorrectUserBodyException(String msg) {
        super(msg);
    }
}
