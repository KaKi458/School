package com.school.service;

import com.school.dto.StudentClassDTO;
import com.school.dto.StudentDTO;
import com.school.model.SubjectInstance;

import java.util.List;

public interface StudentClassService {

    StudentClassDTO addStudentClass(StudentClassDTO studentClassDTO);
    StudentClassDTO getStudentClass(Long studentClassId);
    StudentClassDTO updateStudentClass(Long studentClassId, StudentClassDTO studentClassDTO);
    void deleteStudentClass(Long studentClassId);
    List<StudentDTO> getAllStudentsInClass(Long studentClassId);
    List<SubjectInstance> getAllSubjectInstancesOfClass(Long studentClassId);
}
