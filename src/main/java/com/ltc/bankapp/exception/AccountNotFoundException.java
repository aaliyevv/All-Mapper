package com.ltc.bankapp.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {

        super(message);
    }
}