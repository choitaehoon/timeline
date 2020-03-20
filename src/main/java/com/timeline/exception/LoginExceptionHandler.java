package com.timeline.exception;

import com.timeline.exception.login.LoginUsernameExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginExceptionHandler {

    @ExceptionHandler(LoginUsernameExceptionHandler.class)
    public ResponseEntity<String> handlerEntityNotFoundException(LoginUsernameExceptionHandler e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
