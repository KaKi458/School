package com.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class MarkDTO {

    private Long markId;
    private Long studentId;
    private Long teacherId;
    private Long subjectInstanceId;
    private Date date;

}
