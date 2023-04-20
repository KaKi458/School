package com.school.service;

import com.school.dto.LessonDTO;

public interface LessonService {

    LessonDTO addLesson(LessonDTO lessonDTO);
    LessonDTO getLesson(Long lessonId);
    LessonDTO updateLesson(Long lessonId, LessonDTO lessonDTO);
    void deleteLesson(Long lessonId);
}
