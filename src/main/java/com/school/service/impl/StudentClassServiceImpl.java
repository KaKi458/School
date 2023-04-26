package com.school.service.impl;

import com.school.dto.StudentClassDTO;
import com.school.dto.StudentDTO;
import com.school.model.SubjectInstance;
import com.school.service.StudentClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClassServiceImpl implements StudentClassService {
    @Override
    public StudentClassDTO addStudentClass(StudentClassDTO studentClassDTO) {
        return null;
    }

    @Override
    public StudentClassDTO getStudentClass(long studentClassId) {
        return null;
    }

    @Override
    public StudentClassDTO updateStudentClass(long studentClassId, StudentClassDTO studentClassDTO) {
        return null;
    }

    @Override
    public void deleteStudentClass(long studentClassId) {

    }

    @Override
    public List<StudentDTO> getAllStudentsInClass(long studentClassId) {
        return null;
    }

    @Override
    public List<SubjectInstance> getAllSubjectInstancesOfClass(long studentClassId) {
        return null;
    }
}
