package com.school.dto;

import com.school.security.Role;
import lombok.Getter;

@Getter
public class RegisterDTO {

    String email;
    String firstName;
    String lastName;
    String password;
    Role role;
}
