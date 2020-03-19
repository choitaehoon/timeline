package com.timeline.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class WebToken {

    private String token;

    @Builder
    public WebToken(String token) {
        this.token = token;
    }
}
