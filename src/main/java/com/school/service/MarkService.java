package com.school.service;

import com.school.dto.MarkDTO;
import com.school.model.MarkValue;

public interface MarkService {
    
    MarkDTO addMark(MarkDTO markDTO);
    MarkDTO getMark(long markId);
    MarkDTO updateMark(long markId, MarkValue markValue);
    void deleteMark(long markId);
}
