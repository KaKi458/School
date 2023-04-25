package com.school.service.impl;

import com.school.dto.*;
import com.school.exception.SchoolApiException;
import com.school.model.*;
import com.school.repository.MarkRepository;
import com.school.repository.StudentRepository;
import com.school.service.AuthorizationService;
import com.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;
    private final AuthorizationService authorizationService;


    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public StudentDTO getStudent(Long studentId) {

        if (!authorizationService.authorizeStudentOrTeacher(studentId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        Student student = findStudent(studentId);
        return null;
    }

    @Override
    public StudentDTO updateStudent(Long studentId, StudentDTO studentDTO) {
        return null;
    }

    @Override
    public void deleteStudent(Long studentId) {

    }

    @Override
    public List<SubjectInstanceDTO> getStudentSubjectInstances(Long studentId) {
        return null;
    }

    @Override
    public List<MarkDTO> getRecentStudentMarks(Long studentId) {

        if (!authorizationService.authorizeStudentOrClassTeacher(studentId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        List<Mark> recentMarks = markRepository.findFirst20ByStudentIdOrderByDateDesc(studentId);

        return null;
    }

    @Override
    public List<MarkDTO> getStudentMarksInSubjectInstance(Long studentId, Long subjectInstanceId) {

        if (!authorizationService.authorizeStudentOrSubjectTeacher(studentId, subjectInstanceId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        Student student = findStudent(studentId);
        List<SubjectInstance> subjectInstances = student.getCurrentClass().getSubjectInstances();
        subjectInstances.stream()
                .map(SubjectInstance::getId)
                .filter(id -> Objects.equals(id, subjectInstanceId))
                .findAny().orElseThrow(() -> new SchoolApiException(
                        HttpStatus.BAD_REQUEST,
                        "Student with id "+studentId+" does not attend subject with id "+subjectInstanceId));

        List<Mark> studentMarks =
                markRepository.findByStudentIdAndSubjectInstanceIdOrderByDateDesc(
                        studentId, subjectInstanceId);

        return null;
    }

    @Override
    public List<AbsenceDTO> getStudentAbsences(Long studentId) {

        if (!authorizationService.authorizeStudentOrClassTeacher(studentId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        Student student = findStudent(studentId);
        List<Absence> absences = student.getAbsences();
        return null;
    }

    @Override
    public List<StudentClassDTO> getStudentPreviousClasses(Long studentId) {

        if (!authorizationService.authorizeStudentOrClassTeacher(studentId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        Student student = findStudent(studentId);
        List<StudentClass> previousClasses = student.getPreviousStudentClasses();
        return null;
    }

    @Override
    public List<SubjectInstanceDTO> getStudentPreviousClassSubjectInstances(Long studentId, Long studentClassId) {

        if (!authorizationService.authorizeStudentOrClassTeacher(studentId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        Student student = findStudent(studentId);
        List<StudentClass> previousClasses = student.getPreviousStudentClasses();
        StudentClass previousClass = previousClasses.stream()
                .filter(sc -> Objects.equals(sc.getId(), studentClassId))
                .findAny().orElseThrow(() -> new SchoolApiException(
                        HttpStatus.BAD_REQUEST,
                        "Student with id: "+studentId+" does not attend class with id: "+studentClassId));

        List<SubjectInstance> previousSubjectInstances = previousClass.getSubjectInstances();
        return null;
    }

    private Student findStudent(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Student with given id does not exist"));
    }
}
