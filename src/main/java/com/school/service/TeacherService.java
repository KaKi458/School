package com.school.service;

import com.school.dto.SubjectDTO;
import com.school.dto.SubjectInstanceDTO;
import com.school.dto.TeacherDTO;
import com.school.dto.UserDTO;

import java.util.List;

public interface TeacherService {

    UserDTO addTeacher(TeacherDTO teacherDTO);
    TeacherDTO getTeacher(long teacherId);
    TeacherDTO updateTeacher(long teacherId, TeacherDTO teacherDTO);
    void deleteTeacher(long teacherId);
    List<TeacherDTO> getAllTeachers();
    List<SubjectDTO> getTeacherSubjects(long teacherId);
    List<SubjectInstanceDTO> getTeacherSubjectInstances(long teacherId, long schoolYearId);
}
