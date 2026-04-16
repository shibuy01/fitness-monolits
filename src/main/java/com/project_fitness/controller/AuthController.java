package com.project_fitness.controller;

import com.project_fitness.dto.LoginRequest;
import com.project_fitness.dto.LoginResponse;
import com.project_fitness.dto.RegisterRequest;
import com.project_fitness.dto.UserResponse;
import com.project_fitness.repository.UserRepository;
import com.project_fitness.security.JwtUtils;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_fitness.model.User;
import com.project_fitness.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserResponse>  register(@RequestBody RegisterRequest registerRequest) {

        return ResponseEntity.ok(userService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {
            User user = userRepository.findByEmail(loginRequest.getEmail());
            if(user == null) return ResponseEntity.status(401).build();

            if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.status(401).build();
            }

            String token = jwtUtils.generateToken(user.getId(), user.getRole().name());

            return ResponseEntity.ok(new LoginResponse(
                    token, userService.mapToResponse(user)
            ));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(401).build();
        }
    }
}
