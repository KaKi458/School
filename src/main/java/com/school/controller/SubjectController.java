package com.school.controller;

import com.school.dto.SubjectDTO;
import com.school.dto.SubjectInstanceDTO;
import com.school.dto.TeacherDTO;
import com.school.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public ResponseEntity<SubjectDTO> addSubject(@RequestBody SubjectDTO subjectDTO) {
        SubjectDTO createdSubjectDTO = subjectService.addSubject(subjectDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubjectDTO);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<SubjectDTO> getSubject(@PathVariable Long subjectId) {
        SubjectDTO subjectDTO = subjectService.getSubject(subjectId);
        return ResponseEntity.ok(subjectDTO);
    }

    @PutMapping("/{subjectId}")
    public ResponseEntity<SubjectDTO> updateSubject(@PathVariable Long subjectId,
                                                    @RequestBody SubjectDTO subjectDTO) {
        SubjectDTO updatedSubjectDTO = subjectService.updateSubject(subjectId, subjectDTO);
        return ResponseEntity.ok(updatedSubjectDTO);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{subjectId}/teachers")
    public ResponseEntity<List<TeacherDTO>> getSubjectTeachers(@PathVariable Long subjectId) {
        List<TeacherDTO> teacherDTOs = subjectService.getSubjectTeachers(subjectId);
        return ResponseEntity.ok(teacherDTOs);
    }

    @GetMapping("/{subjectId}/instances")
    public ResponseEntity<List<SubjectInstanceDTO>> getSubjectInstances(
                                                        @PathVariable Long subjectId,
                                                        @RequestParam(name = "schoolYear") Long schoolYearId) {
        List<SubjectInstanceDTO> subjectInstanceDTOs = subjectService.getSubjectInstances(subjectId, schoolYearId);
        return ResponseEntity.ok(subjectInstanceDTOs);
    }

}
