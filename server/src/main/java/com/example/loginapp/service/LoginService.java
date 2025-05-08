package com.example.loginapp.service;

import com.example.loginapp.dto.request.LoginRequest;
import com.example.loginapp.dto.response.ApiResponse;
import com.example.loginapp.dto.response.LoginResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
    
    // Hardcoded credentials as per requirements
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "123456";

    public ApiResponse<?> login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        logger.info("Attempting login for user: {}", username);

        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            String token = generateToken();
            LoginResponseData responseData = new LoginResponseData(token);
            logger.info("Login successful for user: {}", username);
            return ApiResponse.success(responseData, "Login successful");
        } else {
            logger.warn("Login failed for user: {}", username);
            return ApiResponse.fail("Invalid username or password");
        }
    }

    private String generateToken() {
        String token = UUID.randomUUID().toString();
        logger.debug("Generated new token");
        return token;
    }
}