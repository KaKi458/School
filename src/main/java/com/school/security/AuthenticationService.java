package com.school.security;

import com.school.dto.RegisterDTO;
import com.school.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

@Service
public class AuthenticationService {

    private final Random random;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @Value("${app.admin.login}")
    private String adminLogin;

    @Value("${app.admin.password}")
    private String adminPassword;

    @PostConstruct
    private void saveAdmin() {
        if (!userRepository.existsByEmail("ADMIN")) {
            User admin = User.builder()
                    .email(adminLogin)
                    .password(encoder.encode(adminPassword))
                    .role(Role.ADMIN)
                    .firstname("ADMIN")
                    .lastname("ADMIN")
                    .build();
            userRepository.save(admin);
        }
    }

    public AuthenticationService(
            PasswordEncoder encoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager,
            UserRepository userRepository) {
        this.userRepository = userRepository;
        random = new SecureRandom();
        this.encoder = encoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public JwtToken register(RegisterDTO registerDTO) {
        User user = User.builder()
                .firstname(registerDTO.getFirstName())
                .lastname(registerDTO.getLastName())
                .email(registerDTO.getEmail())
                .password(encoder.encode(registerDTO.getPassword()))
                .role(registerDTO.getRole())
                .build();
        User savedUser = userRepository.save(user);
        JwtToken jwtToken = jwtService.generateToken(
                new UsernamePasswordAuthenticationToken(
                        registerDTO.getEmail(), registerDTO.getPassword()));
        return jwtToken;
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
