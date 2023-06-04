package com.school.security;

import com.school.dto.UserDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

@Service
public class AuthenticationService {

    private final Random random;
    private PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            PasswordEncoder encoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager) {
        random = new SecureRandom();
        this.encoder = encoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public JwtToken login(UserDTO userDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTO.getEmail(), userDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtService.generateToken(authentication);
    }

    public String[] generatePassword() {
        String password = Arrays.toString(
                random.ints(8, 'A', 'z').toArray());
        String hash = encoder.encode(password);
        String[] passwordArray = new String[2];
        passwordArray[0] = password;
        passwordArray[1] = hash;
        return passwordArray;
    }
}
