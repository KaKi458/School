package com.school.security;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @PostConstruct
    private void saveAdmin() {
        if (!userRepository.existsByEmail("ADMIN")) {
            Admin admin = new Admin();
            admin.setEmail(SecurityConfig.adminLogin);
            admin.setPassword(SecurityConfig.adminPassword);
            admin.setRole(Role.ADMIN);
            userRepository.save(admin);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}