package com.school.service.impl;

import com.school.dto.MarkDTO;
import com.school.exception.SchoolApiException;
import com.school.mapper.Mapper;
import com.school.model.*;
import com.school.repository.MarkRepository;
import com.school.repository.StudentRepository;
import com.school.repository.SubjectInstanceRepository;
import com.school.repository.TeacherRepository;
import com.school.security.AuthorizationService;
import com.school.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {

    private final MarkRepository markRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectInstanceRepository subjectInstanceRepository;
    private final AuthorizationService authorizationService;
    private final Mapper mapper;

    @Override
    public MarkDTO addMark(MarkDTO markDTO) {

        Teacher teacher = findTeacher(markDTO.getTeacherId());
        SubjectInstance subjectInstance = findSubjectInstance(markDTO.getSubjectInstanceId());
        if (subjectInstance.getTeacher() != teacher) {
            throw new AccessDeniedException("Access denied for subject instance with given ID");
        }
        Student student = findStudent(markDTO.getStudentId());
        if (!student.getSubjectInstances().contains(subjectInstance)) {
            throw new SchoolApiException(HttpStatus.BAD_REQUEST,
                    "Student with given id does not attend subject instance with given ID");
        }
        Mark mark = Mark.builder()
                .teacher(teacher)
                .student(student)
                .subjectInstance(subjectInstance)
                .build();
        mark = markRepository.save(mark);
//        TODO
        return mapper.map(mark);
    }

    @Override
    public MarkDTO getMark(long markId) {

        Mark mark = findMark(markId);
        Student student = mark.getStudent();
        SubjectInstance subjectInstance = mark.getSubjectInstance();
        if (!authorizationService.authorizeStudentOrSubjectTeacher(
                student.getId(), subjectInstance.getId())) {
            throw new AccessDeniedException("Access denied for user with given ID");
        }
        return mapper.map(mark);
    }

    @Override
    public MarkDTO updateMark(long markId, MarkValue markValue) {

        Mark mark = findMark(markId);
        Teacher teacher = mark.getTeacher();
        if (!authorizationService.authorizeTeacher(teacher.getId())) {
            throw new AccessDeniedException("Access denied for teacher with given ID");
        }
        mark.setValue(markValue);
        Mark updatedMark = markRepository.save(mark);
        return mapper.map(updatedMark);
    }

    @Override
    public void deleteMark(long markId) {

        Mark mark = findMark(markId);
        Teacher teacher = mark.getTeacher();
        if (!authorizationService.authorizeTeacher(teacher.getId())) {
            throw new AccessDeniedException("Access denied for teacher with given ID");
        }
        markRepository.delete(mark);
    }

    private Mark findMark(long markId) {
        return markRepository.findById(markId)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Mark with given ID does not exist"));
    }

    private Student findStudent(long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Student with given ID does not exist"));
    }

    private Teacher findTeacher(long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Teacher with given ID does not exist"));
    }

    private SubjectInstance findSubjectInstance(long subjectInstanceId) {
        return subjectInstanceRepository.findById(subjectInstanceId)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Subject Instance with given ID does not exist"));
    }
}
