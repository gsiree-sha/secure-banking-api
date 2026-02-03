package com.sireesha.securebankingapi.controller;

import com.sireesha.securebankingapi.dto.CreateUserRequest;
import com.sireesha.securebankingapi.dto.UserResponse;
import com.sireesha.securebankingapi.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "basicAuth")
@RequestMapping("/api/users")
@Tag(name = "Users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponse> list() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable long id) {
        return userService.getUser(id);
    }
}

