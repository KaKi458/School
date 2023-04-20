package com.school.service.impl;

import com.school.dto.SubjectInstanceDTO;
import com.school.dto.TeacherDTO;
import com.school.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Override
    public TeacherDTO addTeacher(TeacherDTO teacherDTO) {
        return null;
    }

    @Override
    public TeacherDTO getTeacher(Long teacherId) {
        return null;
    }

    @Override
    public TeacherDTO updateTeacher(Long teacherId, TeacherDTO teacherDTO) {
        return null;
    }

    @Override
    public void deleteTeacher(Long teacherId) {

    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return null;
    }

    @Override
    public List<SubjectInstanceDTO> getTeacherSubjectInstances(Long teacherId) {
        return null;
    }
}
