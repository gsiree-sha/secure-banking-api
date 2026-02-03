package com.sireesha.securebankingapi.dto;

import java.time.Instant;

public class UserResponse {
    private Long id;
    private String username;
    private String role;
    private Instant createdAt;

    public UserResponse() {}

    public UserResponse(Long id, String username, String role, Instant createdAt) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getRole() { return role; }
    public Instant getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setRole(String role) { this.role = role; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
