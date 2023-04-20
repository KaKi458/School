package com.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AbsenceDTO {

    private Long absenceId;
    private Long lessonId;
    private Long studentId;
}
