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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
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
}
