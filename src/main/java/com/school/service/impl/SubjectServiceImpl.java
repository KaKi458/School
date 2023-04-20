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
    public SubjectDTO getSubject(Long subjectId) {
        return null;
    }

    @Override
    public SubjectDTO updateSubject(Long subjectId, SubjectDTO subjectDTO) {
        return null;
    }

    @Override
    public void deleteSubject(Long subjectId) {

    }

    @Override
    public List<TeacherDTO> getSubjectTeachers(Long subjectId) {
        return null;
    }

    @Override
    public List<SubjectInstanceDTO> getSubjectInstances(Long subjectId, Long schoolYearId) {
        return null;
    }
}
