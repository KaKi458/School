package com.school.service;

import com.school.dto.MarkDTO;

public interface MarkService {
    
    MarkDTO addMark(MarkDTO markDTO);
    MarkDTO getMark(Long markId);
    MarkDTO updateMark(Long markId, MarkDTO markDTO);
    void deleteMark(Long markId);
}
