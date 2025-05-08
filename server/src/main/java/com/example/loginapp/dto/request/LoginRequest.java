package com.example.loginapp.dto.request;

// Using basic getters/setters for simplicity. Lombok could be added via pom.xml if preferred.
public class LoginRequest {

    private String username;
    private String password;

    // Default constructor (needed for JSON deserialization)
    public LoginRequest() {
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}