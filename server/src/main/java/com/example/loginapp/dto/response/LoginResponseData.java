package com.example.loginapp.dto.response;

// Using basic constructor/getter. Lombok could be added via pom.xml if preferred.
public class LoginResponseData {

    private String token;

    // Constructor
    public LoginResponseData(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }

    // Setter (Optional, depending on usage patterns, but generally good practice for DTOs if mutable)
    public void setToken(String token) {
        this.token = token;
    }
}