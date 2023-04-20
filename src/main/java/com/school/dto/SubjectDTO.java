package com.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SubjectDTO {

    private Long subjectId;
    private String subjectName;
}
