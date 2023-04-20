package com.school.service;

import com.school.dto.*;

import java.util.List;

public interface StudentService {

    StudentDTO addStudent(StudentDTO studentDTO);
    StudentDTO getStudent(Long studentId);
    StudentDTO updateStudent(Long studentId, StudentDTO studentDTO);
    void deleteStudent(Long studentId);
    List<SubjectInstanceDTO> getStudentSubjectInstances(Long studentId);
    List<MarkDTO> getRecentStudentMarks(Long studentId);
    List<MarkDTO> getStudentMarksInSubjectInstance(Long studentId, Long subjectInstanceId);
    List<AbsenceDTO> getStudentAbsences(Long studentId);
    List<StudentClassDTO> getStudentPreviousClasses(Long studentId);
    List<SubjectInstanceDTO> getStudentPreviousClassSubjectInstances(Long studentId, Long studentClassId);
}
