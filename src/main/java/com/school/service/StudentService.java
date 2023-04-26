package com.school.service;

import com.school.dto.*;

import java.util.List;

public interface StudentService {

    StudentDTO addStudent(StudentDTO studentDTO);
    StudentDTO getStudent(long studentId);
    StudentDTO updateStudent(long studentId, StudentDTO studentDTO);
    void deleteStudent(long studentId);
    List<SubjectInstanceDTO> getStudentSubjectInstances(long studentId);
    List<MarkDTO> getRecentStudentMarks(long studentId);
    List<MarkDTO> getStudentMarksInSubjectInstance(long studentId, long subjectInstanceId);
    List<AbsenceDTO> getStudentAbsences(long studentId);
    List<StudentClassDTO> getStudentPreviousClasses(long studentId);
    List<SubjectInstanceDTO> getStudentPreviousClassSubjectInstances(long studentId, long studentClassId);
}
