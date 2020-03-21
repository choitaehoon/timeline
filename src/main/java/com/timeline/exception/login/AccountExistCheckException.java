package com.timeline.exception.login;

public class AccountExistCheckException extends RuntimeException {

    public AccountExistCheckException(String message) {
        super(message);
    }

}
