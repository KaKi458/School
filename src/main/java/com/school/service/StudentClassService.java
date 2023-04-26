package com.school.service;

import com.school.dto.StudentClassDTO;
import com.school.dto.StudentDTO;
import com.school.model.SubjectInstance;

import java.util.List;

public interface StudentClassService {

    StudentClassDTO addStudentClass(StudentClassDTO studentClassDTO);
    StudentClassDTO getStudentClass(long studentClassId);
    StudentClassDTO updateStudentClass(long studentClassId, StudentClassDTO studentClassDTO);
    void deleteStudentClass(long studentClassId);
    List<StudentDTO> getAllStudentsInClass(long studentClassId);
    List<SubjectInstance> getAllSubjectInstancesOfClass(long studentClassId);
}
