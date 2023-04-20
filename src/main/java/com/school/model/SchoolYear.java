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
public class SchoolYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @OneToOne
    private Semester winterSemester;
    @OneToOne
    private Semester summerSemester;
    @OneToMany(mappedBy = "schoolYear")
    private List<StudentClass> studentClassList;
}
