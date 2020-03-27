package com.timeline.dto.request;

import com.timeline.config.valid.post.ValidContentPost;
import com.timeline.config.valid.post.ValidTitlePost;
import lombok.Getter;

@Getter
public class RequestPost {

    @ValidTitlePost
    private String title;

    @ValidContentPost
    private String content;
}
