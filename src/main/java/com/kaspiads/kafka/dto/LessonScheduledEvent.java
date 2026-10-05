package com.kaspiads.kafka.dto;

import java.time.Instant;
import java.util.UUID;

public record LessonScheduledEvent(UUID eventId, UUID lessonId, String pupilId, Instant startsAt) {}