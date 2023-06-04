package com.school.controller;

import com.school.dto.*;
import com.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO createdStudentDTO = studentService.addStudent(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentDTO);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long studentId) {
        StudentDTO studentDTO = studentService.getStudent(studentId);
        return ResponseEntity.ok().body(studentDTO);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long studentId,
                                                    @RequestBody StudentDTO studentDTO) {
        StudentDTO updatedStudentDTO = studentService.updateStudent(studentId, studentDTO);
        return ResponseEntity.ok().body(updatedStudentDTO);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{studentId}/subjectInstances")
    public ResponseEntity<List<SubjectInstanceDTO>> getStudentSubjectInstances(@PathVariable Long studentId) {
        List<SubjectInstanceDTO> subjectInstanceDTOs = studentService.getStudentSubjectInstances(studentId);
        return ResponseEntity.ok(subjectInstanceDTOs);
    }

    @GetMapping("/{studentId}/recentMarks")
    public ResponseEntity<List<MarkDTO>> getStudentRecentMarks(@PathVariable Long studentId) {
        List<MarkDTO> markDTOs = studentService.getRecentStudentMarks(studentId);
        return ResponseEntity.ok(markDTOs);
    }

    @GetMapping("/{studentId}/subjectInstances/{subjectInstanceId}/marks")
    public ResponseEntity<List<MarkDTO>> getStudentMarksInSubjectInstance(
            @PathVariable Long studentId,
            @PathVariable Long subjectInstanceId) {
        List<MarkDTO> markDTOs = studentService.getStudentMarksInSubjectInstance(studentId, subjectInstanceId);
        return ResponseEntity.ok(markDTOs);
    }

    @GetMapping("/{studentId}/absences")
    public ResponseEntity<List<AbsenceDTO>> getStudentAbsences(@PathVariable Long studentId) {
        List<AbsenceDTO> absenceDTOs = studentService.getStudentAbsences(studentId);
        return ResponseEntity.ok(absenceDTOs);
    }

    @GetMapping("/{studentId}/previousClasses")
    public ResponseEntity<List<StudentClassDTO>> getStudentPreviousClasses(@PathVariable Long studentId) {
        List<StudentClassDTO> studentClassDTOs = studentService.getStudentPreviousClasses(studentId);
        return ResponseEntity.ok(studentClassDTOs);
    }

}
