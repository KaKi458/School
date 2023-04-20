package com.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class LessonDTO {

    private Long lessonId;
    private Long subjectInstanceId;
    private Long teacherId;
    private Date date;
}
