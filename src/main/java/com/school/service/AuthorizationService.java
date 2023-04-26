package com.school.service;

public interface AuthorizationService {

    boolean authorizeStudentOrClassTeacher(long studentId);
    boolean authorizeStudentOrTeacher(long studentId);
    boolean authorizeTeacher(long teacherId);
    boolean authorizeStudentOrSubjectTeacher(long studentId, long subjectInstanceId);
}
