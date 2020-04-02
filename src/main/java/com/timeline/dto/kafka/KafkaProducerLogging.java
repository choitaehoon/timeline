package com.timeline.dto.kafka;

import com.timeline.domain.Post;
import lombok.Builder;
import lombok.Getter;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

@Getter
public class KafkaProducerLogging {

    private final ListenableFuture<SendResult<String, Post>> future;
    private final Post message;

    @Builder
    public KafkaProducerLogging(ListenableFuture<SendResult<String, Post>> future, Post message) {
        this.future = future;
        this.message = message;
    }
}
