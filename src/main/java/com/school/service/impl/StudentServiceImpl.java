package com.school.service.impl;

import com.school.dto.*;
import com.school.exception.SchoolApiException;
import com.school.model.*;
import com.school.repository.MarkRepository;
import com.school.repository.StudentRepository;
import com.school.security.AuthorizationService;
import com.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public StudentDTO getStudent(long studentId) {

        if (!authorizationService.authorizeStudentOrTeacher(studentId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        Student student = findStudent(studentId);
        return null;
    }

    @Override
    public StudentDTO updateStudent(long studentId, StudentDTO studentDTO) {
        return null;
    }

    @Override
    public void deleteStudent(long studentId) {

    }

    @Override
    public List<SubjectInstanceDTO> getStudentSubjectInstances(long studentId) {
        return null;
    }

    @Override
    public List<MarkDTO> getRecentStudentMarks(long studentId) {

        if (!authorizationService.authorizeStudentOrClassTeacher(studentId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        List<Mark> recentMarks = markRepository.findFirst20ByStudentIdOrderByUpdatedTimestampDesc(studentId);

        return null;
    }

    @Override
    public List<MarkDTO> getStudentMarksInSubjectInstance(long studentId, long subjectInstanceId) {

        if (!authorizationService.authorizeStudentOrSubjectTeacher(studentId, subjectInstanceId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        Student student = findStudent(studentId);
        List<SubjectInstance> subjectInstances = student.getCurrentClass().getSubjectInstances();
        subjectInstances.stream()
                .filter(si -> si.getId() == subjectInstanceId)
                .findAny().orElseThrow(() -> new SchoolApiException(
                        HttpStatus.BAD_REQUEST,
                        "Student with id "+studentId+" does not attend subject with id "+subjectInstanceId));

        List<Mark> studentMarks =
                markRepository.findByStudentIdAndSubjectInstanceIdOrderByUpdatedTimestampDesc(
                        studentId, subjectInstanceId);

        return null;
    }

    @Override
    public List<AbsenceDTO> getStudentAbsences(long studentId) {

        if (!authorizationService.authorizeStudentOrClassTeacher(studentId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        Student student = findStudent(studentId);
        List<Absence> absences = student.getAbsences();
        return null;
    }

    @Override
    public List<StudentClassDTO> getStudentPreviousClasses(long studentId) {

        if (!authorizationService.authorizeStudentOrClassTeacher(studentId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        Student student = findStudent(studentId);
        List<StudentClass> previousClasses = student.getPreviousStudentClasses();
        return null;
    }

    @Override
    public List<SubjectInstanceDTO> getStudentPreviousClassSubjectInstances(long studentId, long studentClassId) {

        if (!authorizationService.authorizeStudentOrClassTeacher(studentId)) {
            throw new AccessDeniedException("Access denied for student with given id");
        }
        Student student = findStudent(studentId);
        List<StudentClass> previousClasses = student.getPreviousStudentClasses();
        StudentClass previousClass = previousClasses.stream()
                .filter(sc -> sc.getId() == studentClassId)
                .findAny().orElseThrow(() -> new SchoolApiException(
                        HttpStatus.BAD_REQUEST,
                        "Student with id: "+studentId+" does not attend class with id: "+studentClassId));

        List<SubjectInstance> previousSubjectInstances = previousClass.getSubjectInstances();
        return null;
    }

    private Student findStudent(long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Student with given id does not exist"));
    }
}
