package com.timeline.dto.request;

import com.timeline.config.valid.post.ValidContentPost;
import com.timeline.config.valid.post.ValidTitlePost;
import lombok.*;

@Getter
@NoArgsConstructor
public class RequestPost{

    @ValidTitlePost
    private String title;

    @ValidContentPost
    private String content;

    private String writer;

    @Builder
    public RequestPost(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
