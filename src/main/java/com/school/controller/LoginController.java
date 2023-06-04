package com.school.controller;

import com.school.dto.UserDTO;
import com.school.security.AuthenticationService;
import com.school.security.JwtToken;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<JwtToken> login(UserDTO userDTO) {
        JwtToken jwtToken = authenticationService.login(userDTO);
        return ResponseEntity.ok(jwtToken);
    }
}
