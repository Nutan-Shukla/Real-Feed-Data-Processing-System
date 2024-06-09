package com.example.Spring.exception;

public class UserAlreadyFoundException extends RuntimeException {

    public UserAlreadyFoundException(String msg) {
        super(msg);
    }
}
