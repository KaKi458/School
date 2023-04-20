package com.school.controller;

import com.school.dto.SubjectDTO;
import com.school.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        SubjectDTO createdSubjectDTO = subjectService.getSubject(subjectId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubjectDTO);
    }

    @PutMapping("/{subjectId}")
    public ResponseEntity<SubjectDTO> updateSubject(@PathVariable Long subjectId, @RequestBody SubjectDTO subjectDTO) {
        SubjectDTO updatedSubjectDTO = subjectService.updateSubject(subjectId, subjectDTO);
        return ResponseEntity.ok(updatedSubjectDTO);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok().build();
    }
}
