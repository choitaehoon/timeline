package com.timeline.dto.response;

import com.timeline.domain.Post;
import lombok.Getter;

@Getter
public class ResponsePost {

    private final String title;

    private final String content;

    private final String writer;

    public ResponsePost(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.writer = post.getWriter();
    }
}
