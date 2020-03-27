package com.timeline.dto.response;

import com.timeline.domain.Post;
import lombok.Getter;

@Getter
public class ResponsePost {

    private final Post post;

    public ResponsePost(Post post) {
        this.post = post;
    }
}
