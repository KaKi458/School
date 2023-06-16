package com.school.model;

import com.school.security.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static jakarta.persistence.InheritanceType.JOINED;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    private Long id;

    private String firstname;

    private String lastname;

    @ManyToMany
    @JoinTable(
        name = "teacher_subject",
        joinColumns = @JoinColumn(name = "teacher_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> taughtSubjects;

    @OneToMany(mappedBy = "teacher")
    private List<SubjectInstance> subjectInstances;

    @OneToMany(mappedBy = "teacher")
    private List<Mark> marks;

    @OneToMany(mappedBy = "teacher")
    private List<StudentClass> studentClasses;

    @OneToOne
    private StudentClass currentClass;
}
