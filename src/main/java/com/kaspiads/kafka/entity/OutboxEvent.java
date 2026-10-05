package com.kaspiads.kafka.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.Instant;
import java.util.UUID;

@Entity
public class OutboxEvent {
    @Id
    private UUID id = UUID.randomUUID();
    private String aggregateId;   // будущий ключ сообщения в Kafka
    private String type;
    @Column(columnDefinition = "text")
    private String payload;       // JSON
    private Instant createdAt = Instant.now();
    private Instant publishedAt;  // null = ещё не отправлено

    protected OutboxEvent() {}
    public OutboxEvent(String aggregateId, String type, String payload) {
        this.aggregateId = aggregateId;
        this.type = type;
        this.payload = payload;
    }
    public String getAggregateId() { return aggregateId; }
    public String getPayload() { return payload; }
    public void markPublished() { this.publishedAt = Instant.now(); }

}
