package com.kaspiads.kafka.controller;

import com.kaspiads.kafka.event.LessonEventProducer;
import com.kaspiads.kafka.ScheduleLessonRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    private final LessonEventProducer lessonEventProducer;

    public LessonController(LessonEventProducer lessonEventProducer) {
        this.lessonEventProducer = lessonEventProducer;
    }

    @PostMapping
    ResponseEntity<Void> schedule(@RequestBody ScheduleLessonRequest request) {
        lessonEventProducer.send(request.pupilId(), "Lesson starts at: " + request.startsAt());
        return ResponseEntity.accepted().build();
    }
}
