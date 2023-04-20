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
public class SubjectInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Semester semester;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private StudentClass studentClass;
    @OneToMany(mappedBy = "subjectInstance")
    private List<Lesson> lessons;
    @OneToMany(mappedBy = "subjectInstance")
    private List<Mark> marks;
}
