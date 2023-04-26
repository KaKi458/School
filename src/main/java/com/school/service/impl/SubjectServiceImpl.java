package com.school.service.impl;

import com.school.dto.SubjectDTO;
import com.school.dto.SubjectInstanceDTO;
import com.school.dto.TeacherDTO;
import com.school.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Override
    public SubjectDTO addSubject(SubjectDTO subjectDTO) {
        return null;
    }

    @Override
    public SubjectDTO getSubject(long subjectId) {
        return null;
    }

    @Override
    public SubjectDTO updateSubject(long subjectId, SubjectDTO subjectDTO) {
        return null;
    }

    @Override
    public void deleteSubject(long subjectId) {

    }

    @Override
    public List<TeacherDTO> getSubjectTeachers(long subjectId) {
        return null;
    }

    @Override
    public List<SubjectInstanceDTO> getSubjectInstances(long subjectId, long schoolYearId) {
        return null;
    }
}
