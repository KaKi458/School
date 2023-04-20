package com.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SubjectInstanceDTO {

    private Long subjectInstanceId;
    private Long subjectId;
    private Long schoolYearId;
    private Long semesterId;
    private Long studentClassId;
    private Long teacherId;
}
