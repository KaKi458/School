package com.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StudentClassDTO {

    private Long studentClassId;
    private String schoolYear;
    private Long teacherId;
    private int numberOfStudents;
}
