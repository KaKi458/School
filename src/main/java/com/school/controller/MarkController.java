package com.school.controller;

import com.school.dto.MarkDTO;
import com.school.service.MarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("marks")
public class MarkController {

    private final MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @PostMapping
    public ResponseEntity<MarkDTO> addMark(@RequestBody MarkDTO markDTO) {
        MarkDTO createdMarkDTO = markService.addMark(markDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMarkDTO);
    }

    @GetMapping("/{markId}")
    public ResponseEntity<MarkDTO> getMark(@PathVariable Long markId) {
        MarkDTO createdMarkDTO = markService.getMark(markId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMarkDTO);
    }

    @PutMapping("/{markId}")
    public ResponseEntity<MarkDTO> updateMark(@PathVariable Long markId, @RequestBody MarkDTO markDTO) {
        MarkDTO updatedMarkDTO = markService.updateMark(markId, markDTO);
        return ResponseEntity.ok(updatedMarkDTO);
    }

    @DeleteMapping("/{markId}")
    public ResponseEntity<Void> deleteMark(@PathVariable Long markId) {
        markService.deleteMark(markId);
        return ResponseEntity.ok().build();
    }
}
