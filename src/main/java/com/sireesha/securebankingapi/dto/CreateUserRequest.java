package com.sireesha.securebankingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {

    @NotBlank
    @Size(min = 3, max = 80)
    private String username;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;

    @NotBlank
    private String role; 

    public CreateUserRequest() {}

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
}
