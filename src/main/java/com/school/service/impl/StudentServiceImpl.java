package com.school.service.impl;

import com.school.dto.*;
import com.school.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public StudentDTO getStudent(Long studentId) {
        return null;
    }

    @Override
    public StudentDTO updateStudent(Long studentId, StudentDTO studentDTO) {
        return null;
    }

    @Override
    public void deleteStudent(Long studentId) {

    }

    @Override
    public List<SubjectInstanceDTO> getStudentSubjectInstances(Long studentId) {
        return null;
    }

    @Override
    public List<MarkDTO> getRecentStudentMarks(Long studentId) {
        return null;
    }

    @Override
    public List<MarkDTO> getStudentMarksInSubjectInstance(Long studentId, Long subjectInstanceId) {
        return null;
    }

    @Override
    public List<AbsenceDTO> getStudentAbsences(Long studentId) {
        return null;
    }

    @Override
    public List<StudentClassDTO> getStudentPreviousClasses(Long studentId) {
        return null;
    }

    @Override
    public List<SubjectInstanceDTO> getStudentPreviousClassSubjectInstances(Long studentId, Long studentClassId) {
        return null;
    }
}
