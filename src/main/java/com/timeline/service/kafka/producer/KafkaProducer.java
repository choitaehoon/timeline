package com.timeline.service.kafka.producer;

import com.timeline.domain.Post;
import com.timeline.dto.request.RequestPost;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaProducer {

    @Value("${message.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, Post> kafkaTemplate;

    public void sendMessage(Post message) {

        ListenableFuture<SendResult<String, Post>> future = kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Post>>() {

            @Override
            public void onSuccess(SendResult<String, Post> result) {
                log.info("Sent message=[" + message.toString() + "]"
                    +"with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=[" + message.toString() + "] due to : " + ex.getMessage());
            }
        });
    }

}
