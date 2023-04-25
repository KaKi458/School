package com.school.service.impl;

import com.school.exception.SchoolApiException;
import com.school.model.Student;
import com.school.model.SubjectInstance;
import com.school.model.Teacher;
import com.school.repository.MarkRepository;
import com.school.repository.StudentRepository;
import com.school.repository.SubjectInstanceRepository;
import com.school.repository.TeacherRepository;
import com.school.security.Role;
import com.school.security.User;
import com.school.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectInstanceRepository subjectInstanceRepository;

    @Override
    public boolean authorizeStudentOrClassTeacher(Long studentId) {

        User user = findUser();

        switch (user.getRole()) {
            case STUDENT -> {
                return Objects.equals(studentId, user.getId());
            }
            case TEACHER -> {
                Student student = findStudent(studentId);
                Teacher classTeacher = student.getCurrentClass().getTeacher();
                return Objects.equals(classTeacher.getId(), user.getId());
            }
            case HEADMASTER -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public boolean authorizeTeacher(Long teacherId) {
        return false;
    }

    @Override
    public boolean authorizeStudentOrTeacher(Long studentId) {

        User user = findUser();
        if (user.getRole() != Role.TEACHER) {
            return authorizeStudentOrClassTeacher(studentId);
        } else {
            Student student = findStudent(studentId);
            Teacher teacher = findTeacher(user.getId());
            List<Teacher> teachers = student.getCurrentClass().getTeachers();
            return teachers.contains(teacher);
        }
    }

    @Override
    public boolean authorizeStudentOrSubjectTeacher(Long studentId, Long subjectInstanceId) {

        User user = findUser();
        if (user.getRole() != Role.TEACHER) {
            return authorizeStudentOrClassTeacher(studentId);
        } else {
            Student student = findStudent(studentId);
            Teacher teacher = findTeacher(user.getId());
            List<Teacher> teachers = student.getCurrentClass().getTeachers();
            SubjectInstance subjectInstance = findSubjectInstance(subjectInstanceId);
            return teachers.contains(teacher) && teacher.getSubjectInstances().contains(subjectInstance);
        }
    }

    private User findUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    private Student findStudent(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Student with given ID does not exist"));
    }

    private Teacher findTeacher(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Teacher with given ID does not exist"));
    }

    private SubjectInstance findSubjectInstance(Long subjectInstanceId) {
        return subjectInstanceRepository.findById(subjectInstanceId)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Subject Instance with given ID does not exist"));
    }
}
