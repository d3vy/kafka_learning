package com.kaspiads.kafka.repository;

import com.kaspiads.kafka.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {}