package com.school.controller;

import com.school.dto.RegisterDTO;
import com.school.dto.UserDTO;
import com.school.security.AuthenticationService;
import com.school.security.JwtToken;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<JwtToken> login(@RequestBody UserDTO userDTO) {
        JwtToken jwtToken = authenticationService.login(userDTO);
        return ResponseEntity.ok(jwtToken);
    }

    @PostMapping("/register")
    public ResponseEntity<JwtToken> register(@RequestBody RegisterDTO registerDTO) {
        JwtToken jwtToken = authenticationService.register(registerDTO);
        return ResponseEntity.ok(jwtToken);
    }
}
