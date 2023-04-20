package com.school.repository;

import com.school.model.Lesson;
import com.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
