package com.kaspiads.kafka.event;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventConsumer {
    @KafkaListener(topics = "lesson-events")
    void hande(String message) {
        System.out.println("Got: " + message);
    }
}
