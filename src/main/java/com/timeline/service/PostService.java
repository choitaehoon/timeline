package com.timeline.service;

import com.timeline.domain.Post;
import com.timeline.dto.request.RequestPost;
import com.timeline.dto.response.ResponsePost;
import com.timeline.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public ResponsePost writePost(RequestPost requestPost) {
        Post post = convertRequestPostToPost(requestPost);

        postRepository.save(post);

        return new ResponsePost(post);
    }

    private Post convertRequestPostToPost(RequestPost requestPost) {
        return Post.builder()
                .title(requestPost.getTitle())
                .content(requestPost.getContent())
                .build();
    }

}
