package com.sireesha.securebankingapi.service;

import com.sireesha.securebankingapi.dto.CreateUserRequest;
import com.sireesha.securebankingapi.dto.UserResponse;
import com.sireesha.securebankingapi.entity.User;
import com.sireesha.securebankingapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(CreateUserRequest req) {
        if (userRepository.existsByUsername(req.getUsername())) {
            throw new IllegalArgumentException("Username already exists: " + req.getUsername());
        }

        String role = req.getRole().trim().toUpperCase();
        String hash = passwordEncoder.encode(req.getPassword());

        User user = new User(req.getUsername().trim(), hash, role);
        User saved = userRepository.save(user);

        return new UserResponse(saved.getId(), saved.getUsername(), saved.getRole(), saved.getCreatedAt());
    }

    public List<UserResponse> listUsers() {
        return userRepository.findAll().stream()
                .map(u -> new UserResponse(u.getId(), u.getUsername(), u.getRole(), u.getCreatedAt()))
                .toList();
    }

    public UserResponse getUser(long id) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
        return new UserResponse(u.getId(), u.getUsername(), u.getRole(), u.getCreatedAt());
    }
    
}
