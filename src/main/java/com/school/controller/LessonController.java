package com.school.controller;

import com.school.dto.LessonDTO;
import com.school.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lessons")
public class LessonController {
    
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    public ResponseEntity<LessonDTO> addLesson(@RequestBody LessonDTO lessonDTO) {
        LessonDTO createdLessonDTO = lessonService.addLesson(lessonDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLessonDTO);
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<LessonDTO> getLesson(@PathVariable Long lessonId) {
        LessonDTO lessonDTO = lessonService.getLesson(lessonId);
        return ResponseEntity.ok(lessonDTO);
    }

    @PutMapping("/{lessonId}")
    public ResponseEntity<LessonDTO> updateLesson(@PathVariable Long lessonId, @RequestBody LessonDTO lessonDTO) {
        LessonDTO updatedLessonDTO = lessonService.updateLesson(lessonId, lessonDTO);
        return ResponseEntity.ok(updatedLessonDTO);
    }
    
    @DeleteMapping("/{lessonId}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long lessonId) {
        lessonService.deleteLesson(lessonId);
        return ResponseEntity.ok().build();
    }
}
