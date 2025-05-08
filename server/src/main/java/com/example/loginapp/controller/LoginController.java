package com.example.loginapp.controller;

import com.example.loginapp.dto.request.LoginRequest;
import com.example.loginapp.dto.response.ApiResponse;
import com.example.loginapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    @ResponseBody // Ensures the return value is serialized into the response body
    public ApiResponse<?> handleLogin(@RequestBody LoginRequest loginRequest) throws InterruptedException {
        // Delegate the logic to the LoginService
        Thread.sleep(1000);
        return loginService.login(loginRequest);
    }
}