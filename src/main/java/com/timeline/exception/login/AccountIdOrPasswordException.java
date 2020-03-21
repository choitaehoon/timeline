package com.timeline.exception.login;

import javax.servlet.ServletException;

public class AccountIdOrPasswordException extends ServletException {

    public AccountIdOrPasswordException(String message) {
        super(message);
    }
}
