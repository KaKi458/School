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
public class Teacher {

    @Id
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @ManyToMany
    @JoinTable(
            name = "teacher_subject",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> taughtSubjects;
    @OneToMany(mappedBy = "teacher")
    private List<SubjectInstance> subjectInstances;
    @OneToMany(mappedBy = "teacher")
    private List<Mark> marksList;
    @OneToMany(mappedBy = "teacher")
    private List<StudentClass> studentClasses;
    @OneToOne
    private StudentClass currentClass;
}
