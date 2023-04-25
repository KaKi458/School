package com.school.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private SchoolYear schoolYear;
    @ManyToOne
    private Teacher teacher;
    @OneToMany(mappedBy = "currentClass")
    private List<Student> students;
    @OneToMany(mappedBy = "studentClass")
    private List<SubjectInstance> subjectInstances;

    public List<Teacher> getTeachers() {
        return subjectInstances.stream().map(SubjectInstance::getTeacher).toList();
    }
}
