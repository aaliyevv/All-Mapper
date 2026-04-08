package com.ltc.bankapp.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {

        super(message);
    }
}