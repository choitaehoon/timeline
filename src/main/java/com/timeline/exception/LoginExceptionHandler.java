package com.timeline.exception;

import com.timeline.exception.login.AccountIdOrPasswordException;
import com.timeline.exception.login.AccountExistCheckException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginExceptionHandler {

    @ExceptionHandler(AccountExistCheckException.class)
    public ResponseEntity handlerEntityNotFoundException(AccountExistCheckException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccountIdOrPasswordException.class)
    public ResponseEntity handlerAccountException(AccountIdOrPasswordException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
