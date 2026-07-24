package com.kirti.employee_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.kirti.employee_management_system.dto.LoginRequest;
import com.kirti.employee_management_system.dto.LoginResponse;
import com.kirti.employee_management_system.entity.User;
import com.kirti.employee_management_system.repository.UserRepository;
import com.kirti.employee_management_system.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        // Authenticate username & password
    	System.out.println("******** LOGIN API HIT ********");
    	System.out.println("Username = " + request.getUsername());
    	System.out.println("Password = " + request.getPassword());
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()));

        // Fetch user from database
        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        // Generate JWT Token
        String token =
                jwtTokenProvider.generateToken(user.getUsername());

        // Return token + user details
        return new LoginResponse(
                token,
                user.getUsername(),
                user.getRole());
    }
}