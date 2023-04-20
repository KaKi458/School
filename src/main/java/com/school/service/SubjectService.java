package com.school.service;

import com.school.dto.SubjectDTO;

public interface SubjectService {
    
    SubjectDTO addSubject(SubjectDTO subjectDTO);
    SubjectDTO getSubject(Long subjectId);
    SubjectDTO updateSubject(Long subjectId, SubjectDTO subjectDTO);
    void deleteSubject(Long subjectId);
}
