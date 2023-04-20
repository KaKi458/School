package com.school.service;

import com.school.dto.SubjectDTO;
import com.school.dto.SubjectInstanceDTO;
import com.school.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {

    TeacherDTO addTeacher(TeacherDTO teacherDTO);
    TeacherDTO getTeacher(Long teacherId);
    TeacherDTO updateTeacher(Long teacherId, TeacherDTO teacherDTO);
    void deleteTeacher(Long teacherId);
    List<TeacherDTO> getAllTeachers();
    List<SubjectDTO> getTeacherSubjects(Long teacherId);
    List<SubjectInstanceDTO> getTeacherSubjectInstances(Long teacherId, Long schoolYearId);
}
