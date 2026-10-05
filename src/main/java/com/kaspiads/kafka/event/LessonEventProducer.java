package com.kaspiads.kafka.event;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LessonEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public LessonEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void send(String pupilId, String message) {
        kafkaTemplate.send("lesson-events", pupilId, message);
    }
}
