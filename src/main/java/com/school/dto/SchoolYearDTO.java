package com.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class SchoolYearDTO {

    private Long schoolYearId;
    private Date startDate;
    private Date endDate;
    private Long winterSemesterId;
    private Long summerSemesterId;
}
