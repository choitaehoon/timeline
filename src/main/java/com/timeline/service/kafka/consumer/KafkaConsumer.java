package com.timeline.service.kafka.consumer;

import com.timeline.domain.Post;
import com.timeline.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaConsumer {

    private final PostRepository postRepository;

    @KafkaListener(topics = "${message.topic.name}", groupId = "${kafka.groupId}")
    public Post postListener(Post message) {

        postRepository.save(message);

        return message;
    }

}
