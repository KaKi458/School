package com.school.controller;

import com.school.dto.StudentClassDTO;
import com.school.service.StudentClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("studentClasses")
public class StudentClassController {

    private final StudentClassService studentClassService;

    public StudentClassController(StudentClassService studentClassService) {
        this.studentClassService = studentClassService;
    }

    @PostMapping
    public ResponseEntity<StudentClassDTO> addStudentClass(@RequestBody StudentClassDTO studentClassDTO) {
        StudentClassDTO createdStudentClassDTO = studentClassService.addStudentClass(studentClassDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentClassDTO);
    }

    @GetMapping("/{studentClassId}")
    public ResponseEntity<StudentClassDTO> getStudentClass(@PathVariable Long studentClassId) {
        StudentClassDTO createdStudentClassDTO = studentClassService.getStudentClass(studentClassId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentClassDTO);
    }

    @PutMapping("/{studentClassId}")
    public ResponseEntity<StudentClassDTO> updateStudentClass(@PathVariable Long studentClassId, @RequestBody StudentClassDTO studentClassDTO) {
        StudentClassDTO updatedStudentClassDTO = studentClassService.updateStudentClass(studentClassId, studentClassDTO);
        return ResponseEntity.ok(updatedStudentClassDTO);
    }

    @DeleteMapping("/{studentClassId}")
    public ResponseEntity<Void> deleteStudentClass(@PathVariable Long studentClassId) {
        studentClassService.deleteStudentClass(studentClassId);
        return ResponseEntity.ok().build();
    }
}
