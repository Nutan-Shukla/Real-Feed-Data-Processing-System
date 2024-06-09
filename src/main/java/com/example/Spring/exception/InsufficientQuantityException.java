package com.example.Spring.exception;

public class InsufficientQuantityException extends RuntimeException {
    public InsufficientQuantityException(String s) {
        super(s);
    }
}
