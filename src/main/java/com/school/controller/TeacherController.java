package com.school.controller;

import com.school.dto.SubjectDTO;
import com.school.dto.SubjectInstanceDTO;
import com.school.dto.TeacherDTO;
import com.school.dto.UserDTO;
import com.school.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> addTeacher(@RequestBody TeacherDTO teacherDTO) {
        UserDTO createdUserDTO = teacherService.addTeacher(teacherDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDTO);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDTO> getTeacher(@PathVariable Long teacherId) {
        TeacherDTO teacherDTO = teacherService.getTeacher(teacherId);
        return ResponseEntity.ok(teacherDTO);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable Long teacherId,
                                                    @RequestBody TeacherDTO teacherDTO) {
        TeacherDTO updatedTeacherDTO = teacherService.updateTeacher(teacherId, teacherDTO);
        return ResponseEntity.ok(updatedTeacherDTO);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{teacherId}/subjects")
    public ResponseEntity<List<SubjectDTO>> getTeacherSubjects(@PathVariable Long teacherId) {
        List<SubjectDTO> teacherSubjectDTOs = teacherService.getTeacherSubjects(teacherId);
        return ResponseEntity.ok(teacherSubjectDTOs);
    }

    @GetMapping("/{teacherId}/subjectInstances")
    public ResponseEntity<List<SubjectInstanceDTO>> getTeacherSubjectInstances(@PathVariable Long teacherId,
                                                                       @RequestParam Long schoolYearId) {
        List<SubjectInstanceDTO> teacherSubjectInstanceDTOs =
                teacherService.getTeacherSubjectInstances(teacherId, schoolYearId);
        return ResponseEntity.ok(teacherSubjectInstanceDTOs);
    }
}
