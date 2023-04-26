package com.school.service;

import com.school.dto.MarkDTO;

public interface MarkService {
    
    MarkDTO addMark(MarkDTO markDTO);
    MarkDTO getMark(long markId);
    MarkDTO updateMark(long markId, MarkDTO markDTO);
    void deleteMark(long markId);
}
