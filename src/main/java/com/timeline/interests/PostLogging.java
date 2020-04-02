package com.timeline.interests;

import com.timeline.domain.Post;
import com.timeline.dto.kafka.KafkaProducerLogging;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Aspect
@Configuration
public class PostLogging {

    @AfterReturning(value = "execution(* com.timeline.service.kafka.consumer.KafkaConsumer.*(..))", returning = "message")
    public void postConsumerLogging(Post message){
        log.info("Post success Received Messasge in group : " + message.toString());
    }

    @AfterReturning(value = "execution(* com.timeline.service.kafka.producer.KafkaProducer.*(..))", returning = "producerLogging")
    public void postProducerLogging(KafkaProducerLogging producerLogging) {

        producerLogging.getFuture().addCallback(new ListenableFutureCallback<SendResult<String, Post>>() {

            @Override
            public void onSuccess(SendResult<String, Post> result) {
                log.info("Sent message=[" + producerLogging.getMessage().toString() + "]"
                        +"with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=[" + producerLogging.getMessage().toString() + "] due to : " + ex.getMessage());
            }
        });
    }

}
