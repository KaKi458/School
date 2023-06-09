package com.school.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Getter
@Setter
@Builder
public class TeacherDTO {

    private Long teacherId;

    @JsonProperty(required = true)
    private String firstName;

    @JsonProperty(required = true)
    private String lastName;

    @JsonProperty(required = true)
    private String email;

    private Long classId;

    @JsonProperty(required = true)
    private List<String> taughtSubjects;
}
