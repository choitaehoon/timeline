package com.timeline.dto.response;

import com.timeline.domain.Post;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponsePostAll {
    private final List<Post> posts;

    public ResponsePostAll(List<Post> posts) {
        this.posts = posts;
    }
}
