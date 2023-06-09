package com.school.service.impl;

import com.school.dto.SubjectDTO;
import com.school.dto.SubjectInstanceDTO;
import com.school.dto.TeacherDTO;
import com.school.dto.UserDTO;
import com.school.exception.SchoolApiException;
import com.school.mapper.Mapper;
import com.school.model.Subject;
import com.school.model.SubjectInstance;
import com.school.model.Teacher;
import com.school.repository.SubjectRepository;
import com.school.repository.TeacherRepository;
import com.school.security.AuthenticationService;
import com.school.security.Role;
import com.school.security.User;
import com.school.security.UserRepository;
import com.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    
    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final Mapper mapper;
    private final AuthenticationService authenticationService;
    
    @Override
    public UserDTO addTeacher(TeacherDTO teacherDTO) {

        if (userRepository.existsByEmail(teacherDTO.getEmail())) {
            throw new SchoolApiException(HttpStatus.BAD_REQUEST, "User with given email already exists");
        }

        String[] password = authenticationService.generatePassword();

        User user = User.builder()
                .email(teacherDTO.getEmail())
                .firstname(teacherDTO.getFirstName())
                .lastname(teacherDTO.getLastName())
                .role(Role.TEACHER)
                .password(password[1])
                .build();

        User savedUser = userRepository.save(user);

        List<Subject> subjects = teacherDTO.getTaughtSubjects()
                .stream().map(this::findSubject).toList();

        Teacher teacher = Teacher.builder()
                .id(savedUser.getId())
                .firstname(teacherDTO.getFirstName())
                .lastname(teacherDTO.getLastName())
                .taughtSubjects(subjects)
                .build();

        Teacher savedTeacher = teacherRepository.save(teacher);

        return UserDTO.builder()
                .userId(savedTeacher.getId())
                .firstName(savedTeacher.getFirstname())
                .lastName(savedTeacher.getLastname())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .build();
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

    private Subject findSubject(String subject) {
        return subjectRepository.findByName(subject)
                .orElseThrow(() -> new SchoolApiException(
                        HttpStatus.NOT_FOUND, "Subject with name "+subject+" does not exist"));
    }
}
