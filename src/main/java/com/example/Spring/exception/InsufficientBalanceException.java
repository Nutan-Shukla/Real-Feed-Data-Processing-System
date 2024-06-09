package com.example.Spring.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String balanceIsNotSufficient) {

        super(balanceIsNotSufficient);
    }
}
