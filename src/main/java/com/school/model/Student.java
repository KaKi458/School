package com.school.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    private Long id;

    private String firstname;

    private String lastname;

    @ManyToOne
    private StudentClass currentClass;

    @ManyToMany
    @JoinTable(
        name = "student_previous_class",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "previous_class_id")
    )
    private List<StudentClass> previousStudentClasses;

    @OneToMany(mappedBy = "student")
    private List<Mark> marks;

    @OneToMany(mappedBy = "student")
    private List<Absence> absences;

    public List<SubjectInstance> getSubjectInstances() {
        return currentClass.getSubjectInstances();
    }
}
