package com.kirti.employee_management_system.dto;

public class LoginResponse {

    private String token;
    private String username;
    private String role;

    // Default Constructor
    public LoginResponse() {
    }

    // Parameterized Constructor
    public LoginResponse(String token, String username, String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }

    // Getter for Token
    public String getToken() {
        return token;
    }

    // Setter for Token
    public void setToken(String token) {
        this.token = token;
    }

    // Getter for Username
    public String getUsername() {
        return username;
    }

    // Setter for Username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for Role
    public String getRole() {
        return role;
    }

    // Setter for Role
    public void setRole(String role) {
        this.role = role;
    }
}