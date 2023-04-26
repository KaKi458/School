package com.school.service;

import com.school.dto.SubjectInstanceDTO;

import java.util.List;

public interface SubjectInstanceService {

    SubjectInstanceDTO addSubjectInstance(SubjectInstanceDTO subjectInstanceDTO);
    SubjectInstanceDTO getSubjectInstance(long subjectInstanceId);
    SubjectInstanceDTO updateSubjectInstance(long subjectInstanceId, SubjectInstanceDTO subjectInstanceDTO);
    void deleteSubjectInstance(long subjectInstanceId);
}
