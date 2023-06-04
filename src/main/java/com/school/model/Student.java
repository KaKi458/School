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
@SuperBuilder
@Inheritance(strategy = JOINED)
public class Student extends User {

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
