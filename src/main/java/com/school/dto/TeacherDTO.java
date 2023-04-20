package com.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TeacherDTO {

    private Long teacherId;
    private String firstName;
    private String lastName;
    private Long teacherClassId;
}
