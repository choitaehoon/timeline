package com.timeline.exception.post;

import javax.servlet.ServletException;

public class PostTitleOrContentExceptionHandler extends ServletException {

    public PostTitleOrContentExceptionHandler(String message) {
        super(message);
    }
}
