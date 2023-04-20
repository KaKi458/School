package com.school.controller;

import com.school.dto.TeacherDTO;
import com.school.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> addTeacher(@RequestBody TeacherDTO teacherDTO) {
        TeacherDTO createdTeacherDTO = teacherService.addTeacher(teacherDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeacherDTO);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDTO> getTeacher(@PathVariable Long teacherId) {
        TeacherDTO createdTeacherDTO = teacherService.getTeacher(teacherId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeacherDTO);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable Long teacherId, @RequestBody TeacherDTO teacherDTO) {
        TeacherDTO updatedTeacherDTO = teacherService.updateTeacher(teacherId, teacherDTO);
        return ResponseEntity.ok(updatedTeacherDTO);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok().build();
    }
}
