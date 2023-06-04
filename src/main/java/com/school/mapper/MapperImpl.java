package com.school.mapper;

import com.school.dto.*;
import com.school.model.*;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements Mapper {

    @Override
    public AbsenceDTO map(Absence absence) {
        return null;
    }

    @Override
    public LessonDTO map(Lesson lesson) {
        return null;
    }

    @Override
    public MarkDTO map(Mark mark) {
        return null;
    }

    @Override
    public SchoolYearDTO map(SchoolYear schoolYear) {
        return null;
    }

    @Override
    public SemesterDTO map(Semester semester) {
        return null;
    }

    @Override
    public StudentClassDTO map(StudentClass studentClass) {
        return null;
    }

    @Override
    public StudentDTO map(Student student) {
        return null;
    }

    @Override
    public SubjectDTO map(Subject subject) {
        return null;
    }

    @Override
    public SubjectInstanceDTO map(SubjectInstance subjectInstance) {
        return null;
    }

    @Override
    public TeacherDTO map(Teacher teacher) {
        TeacherDTO teacherDTO = TeacherDTO.builder()
                .teacherId(teacher.getId())
                .firstName(teacher.getFirstname())
                .lastName(teacher.getLastname())
                .email(teacher.getEmail())
                .classId(teacher.getCurrentClass() != null ?
                        teacher.getCurrentClass().getId() : null)
                .build();
        return teacherDTO;
    }
}
