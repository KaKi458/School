package com.school.controller;

import com.school.dto.SubjectInstanceDTO;
import com.school.service.SubjectInstanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subjectInstances")
public class SubjectInstanceController {

    private final SubjectInstanceService subjectInstanceService;

    public SubjectInstanceController(SubjectInstanceService subjectInstanceService) {
        this.subjectInstanceService = subjectInstanceService;
    }

    @PostMapping
    public ResponseEntity<SubjectInstanceDTO> addSubjectInstance(@RequestBody SubjectInstanceDTO subjectInstanceDTO) {
        SubjectInstanceDTO createdSubjectInstanceDTO = subjectInstanceService.addSubjectInstance(subjectInstanceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubjectInstanceDTO);
    }

    @GetMapping("/{subjectInstanceId}")
    public ResponseEntity<SubjectInstanceDTO> getSubjectInstance(@PathVariable Long subjectInstanceId) {
        SubjectInstanceDTO createdSubjectInstanceDTO = subjectInstanceService.getSubjectInstance(subjectInstanceId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubjectInstanceDTO);
    }

    @PutMapping("/{subjectInstanceId}")
    public ResponseEntity<SubjectInstanceDTO> updateSubjectInstance(@PathVariable Long subjectInstanceId, @RequestBody SubjectInstanceDTO subjectInstanceDTO) {
        SubjectInstanceDTO updatedSubjectInstanceDTO = subjectInstanceService.updateSubjectInstance(subjectInstanceId, subjectInstanceDTO);
        return ResponseEntity.ok(updatedSubjectInstanceDTO);
    }

    @DeleteMapping("/{subjectInstanceId}")
    public ResponseEntity<Void> deleteSubjectInstance(@PathVariable Long subjectInstanceId) {
        subjectInstanceService.deleteSubjectInstance(subjectInstanceId);
        return ResponseEntity.ok().build();
    }
}
