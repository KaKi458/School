package com.school.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
@Builder
public class UserDTO {

    private Long userId;

    private String firstName;

    private String lastName;

    @JsonProperty(required = true)
    private String email;

    @JsonProperty(required = true)
    private String password;
}
