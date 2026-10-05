package com.kaspiads.kafka.service;

import com.kaspiads.kafka.dto.LessonScheduledEvent;
import com.kaspiads.kafka.entity.Lesson;
import com.kaspiads.kafka.entity.OutboxEvent;
import com.kaspiads.kafka.repository.LessonRepository;
import com.kaspiads.kafka.repository.OutboxRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

import java.time.Instant;
import java.util.UUID;

@Service
public class LessonService {
    private final LessonRepository lessons;
    private final OutboxRepository outbox;
    private final ObjectMapper objectMapper;

    public LessonService(LessonRepository lessons, OutboxRepository outbox, ObjectMapper objectMapper) {
        this.lessons = lessons;
        this.outbox = outbox;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public void schedule(String pupilId, Instant startsAt) {
        Lesson lesson = lessons.save(new Lesson(pupilId, startsAt));
        var event = new LessonScheduledEvent(UUID.randomUUID(), lesson.getId(), pupilId, startsAt);
        outbox.save(new OutboxEvent(pupilId, "Lesson scheduled", toJson(event)));
    }

    private String toJson(Object o) {
        try { return objectMapper.writeValueAsString(o); }
        catch (RuntimeException e) { throw new IllegalStateException(e); }
    }
}
