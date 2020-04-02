package com.timeline.service;

import com.timeline.domain.Post;
import com.timeline.dto.request.RequestPost;
import com.timeline.dto.response.ResponsePost;
import com.timeline.dto.response.ResponsePostAll;
import com.timeline.repository.PostRepository;
import com.timeline.service.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final KafkaProducer kafkaProducer;

    public ResponsePost writePost(RequestPost requestPost, String writer) {
        Post post = convertRequestPostToPost(requestPost, writer);

        kafkaProducer.sendMessage(post);

        return new ResponsePost(post);
    }

    public ResponsePostAll readPostAll() {
        return new ResponsePostAll(postRepository.findAll());
    }

    public Post convertRequestPostToPost(RequestPost requestPost, String writer) {
        return Post.builder()
                .title(requestPost.getTitle())
                .content(requestPost.getContent())
                .writer(writer)
                .build();
    }

}
