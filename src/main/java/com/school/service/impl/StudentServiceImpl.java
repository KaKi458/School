package com.school.service.impl;

import com.school.dto.*;
import com.school.exception.SchoolApiException;
import com.school.model.Student;
import com.school.repository.StudentRepository;
import com.school.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public StudentDTO getStudent(Long studentId) {
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
        return null;
    }

    @Override
    public List<MarkDTO> getStudentMarksInSubjectInstance(Long studentId, Long subjectInstanceId) {
        return null;
    }

    @Override
    public List<AbsenceDTO> getStudentAbsences(Long studentId) {
        return null;
    }

    @Override
    public List<StudentClassDTO> getStudentPreviousClasses(Long studentId) {
        return null;
    }

    @Override
    public List<SubjectInstanceDTO> getStudentPreviousClassSubjectInstances(Long studentId, Long studentClassId) {
        return null;
    }

    private Student findStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Student with given id does not exist"
                ));
        return student;
    }
}
