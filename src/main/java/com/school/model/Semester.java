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
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private SchoolYear schoolYear;
    @Enumerated(EnumType.STRING)
    private SemesterType semesterType;
    @OneToMany(mappedBy = "semester")
    private List<SubjectInstance> subjectInstanceList;

    enum SemesterType {
        WINTER, SUMMER;
    }
}
