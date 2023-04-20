package com.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StudentDTO {
    private Long studentId;
    private String firstName;
    private String lastName;
    private Long studentClassId;
}
