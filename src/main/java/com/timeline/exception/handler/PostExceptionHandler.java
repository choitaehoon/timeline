package com.timeline.exception.handler;

import com.timeline.exception.post.PostTitleOrContentExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionHandler {

    @ExceptionHandler(PostTitleOrContentExceptionHandler.class)
    public ResponseEntity handlerPostException(PostTitleOrContentExceptionHandler e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
