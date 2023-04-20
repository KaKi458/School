package com.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SemesterDTO {

    private Long semesterId;
    private String semesterType;
    private Long schoolYearId;
}
