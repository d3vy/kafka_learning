package com.kaspiads.kafka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Lesson {
    @Id
    private UUID id = UUID.randomUUID();
    private String pupilId;
    private Instant startsAt;

    protected Lesson() {}
    public Lesson(String pupilId, Instant startsAt) {
        this.pupilId = pupilId;
        this.startsAt = startsAt;
    }

    public UUID getId() { return id; }
    public String getPupilId() { return pupilId; }
    public Instant getStartsAt() { return startsAt; }
}

