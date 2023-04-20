package com.school.service;

import com.school.dto.SubjectDTO;
import com.school.dto.SubjectInstanceDTO;
import com.school.dto.TeacherDTO;

import java.util.List;

public interface SubjectService {
    
    SubjectDTO addSubject(SubjectDTO subjectDTO);
    SubjectDTO getSubject(Long subjectId);
    SubjectDTO updateSubject(Long subjectId, SubjectDTO subjectDTO);
    void deleteSubject(Long subjectId);
    List<TeacherDTO> getSubjectTeachers(Long subjectId);
    List<SubjectInstanceDTO> getSubjectInstances(Long subjectId, Long schoolYearId);
}
