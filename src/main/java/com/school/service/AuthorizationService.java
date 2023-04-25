package com.school.service;

public interface AuthorizationService {

    boolean authorizeStudentOrClassTeacher(Long studentId);
    boolean authorizeStudentOrTeacher(Long studentId);
    boolean authorizeTeacher(Long teacherId);
    boolean authorizeStudentOrSubjectTeacher(Long studentId, Long subjectInstanceId);
}
