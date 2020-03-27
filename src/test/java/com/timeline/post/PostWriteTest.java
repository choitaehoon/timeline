package com.timeline.post;

import com.timeline.dto.request.RequestPost;
import com.timeline.dto.response.ResponsePost;
import com.timeline.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostWriteTest {

    @Autowired
    private PostService postService;

    @Test
    public void post_write_exist_success() {
        RequestPost post = writePost();

        ResponsePost responsePost = postService.writePost(post, "writer");

        assertThat(responsePost.getPost().getContent()).isEqualTo("this is test");
        assertThat(responsePost.getPost().getTitle()).isEqualTo("test");
    }

    @Test
    public void post_write_not_exist_fail() {
        RequestPost post = new RequestPost();

        ResponsePost responsePost = postService.writePost(post, "writer");

        assertThat(responsePost.getPost().getContent()).isNull();
        assertThat(responsePost.getPost().getTitle()).isNull();
    }

    private RequestPost writePost() {
        return RequestPost.builder()
                .title("test")
                .content("this is test")
                .build();
    }
}
