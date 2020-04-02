package com.timeline.service.kafka.producer;

import com.timeline.domain.Post;
import com.timeline.dto.kafka.KafkaProducerLogging;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaProducer {

    @Value("${message.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, Post> kafkaTemplate;

    public KafkaProducerLogging sendMessage(Post message) {

        return KafkaProducerLogging.builder()
                .future(kafkaTemplate.send(topicName, message))
                .message(message)
                .build();

    }

}
