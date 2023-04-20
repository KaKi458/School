package com.school.service;

import com.school.dto.SubjectInstanceDTO;

import java.util.List;

public interface SubjectInstanceService {

    SubjectInstanceDTO addSubjectInstance(SubjectInstanceDTO subjectInstanceDTO);
    SubjectInstanceDTO getSubjectInstance(Long subjectInstanceId);
    SubjectInstanceDTO updateSubjectInstance(Long subjectInstanceId, SubjectInstanceDTO subjectInstanceDTO);
    void deleteSubjectInstance(Long subjectInstanceId);
}
