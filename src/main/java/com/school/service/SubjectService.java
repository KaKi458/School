package com.school.service;

import com.school.dto.SubjectDTO;
import com.school.dto.SubjectInstanceDTO;
import com.school.dto.TeacherDTO;

import java.util.List;

public interface SubjectService {
    
    SubjectDTO addSubject(SubjectDTO subjectDTO);
    SubjectDTO getSubject(long subjectId);
    SubjectDTO updateSubject(long subjectId, SubjectDTO subjectDTO);
    void deleteSubject(long subjectId);
    List<TeacherDTO> getSubjectTeachers(long subjectId);
    List<SubjectInstanceDTO> getSubjectInstances(long subjectId, long schoolYearId);
}
