package com.project_fitness.service;

import org.springframework.stereotype.Service;

import com.project_fitness.model.User;
import com.project_fitness.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    
    public User register(User user) {
        return userRepository.save(user);
    }
}