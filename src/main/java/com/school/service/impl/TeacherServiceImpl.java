package com.school.service.impl;

import com.school.dto.SubjectDTO;
import com.school.dto.SubjectInstanceDTO;
import com.school.dto.TeacherDTO;
import com.school.exception.SchoolApiException;
import com.school.mapper.Mapper;
import com.school.model.Subject;
import com.school.model.SubjectInstance;
import com.school.model.Teacher;
import com.school.repository.TeacherRepository;
import com.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    
    private final TeacherRepository teacherRepository;
    private final Mapper mapper;
    
    @Override
    public TeacherDTO addTeacher(TeacherDTO teacherDTO) {
        return null;
    }

    @Override
    public TeacherDTO getTeacher(long teacherId) {
        Teacher teacher = findTeacher(teacherId);
        return mapper.map(teacher);
    }

    @Override
    public TeacherDTO updateTeacher(long teacherId, TeacherDTO teacherDTO) {
        return null;
    }

    @Override
    public void deleteTeacher(long teacherId) {

    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        
        return null;
    }

    @Override
    public List<SubjectDTO> getTeacherSubjects(long teacherId) {
        
        Teacher teacher = findTeacher(teacherId);
        List<Subject> subjects = teacher.getTaughtSubjects();
        
        return null;
    }
    @Override
    public List<SubjectInstanceDTO> getTeacherSubjectInstances(long teacherId, long semesterId) {
        Teacher teacher = findTeacher(teacherId);
        List<SubjectInstance> subjectInstances = teacher.getSubjectInstances()
                .stream().filter(si -> si.getSemester().getId() == semesterId)
                .toList();
        
        return null;
    }
    
    private Teacher findTeacher(long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Teacher with given ID does not exist"));
    }
}
