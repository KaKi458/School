package com.school.service;

import com.school.dto.LessonDTO;

public interface LessonService {

    LessonDTO addLesson(LessonDTO lessonDTO);
    LessonDTO getLesson(long lessonId);
    LessonDTO updateLesson(long lessonId, LessonDTO lessonDTO);
    void deleteLesson(long lessonId);
}
