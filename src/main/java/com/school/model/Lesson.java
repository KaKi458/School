package com.school.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @ManyToOne
    private SubjectInstance subjectInstance;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "lesson")
    private List<Absence> absences;
}
