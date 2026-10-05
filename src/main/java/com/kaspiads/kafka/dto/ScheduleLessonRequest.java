package com.kaspiads.kafka.dto;

import java.time.Instant;

record ScheduleLessonRequest(String pupilId, Instant startsAt) {}