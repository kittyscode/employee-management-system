package com.kirti.employee_management_system;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String hash = "$2a$10$pYnTXj3vc1ApiSUp7mIa4eJTsqHSBaOhnGEGMJzP1QfwDgNJJNYwS";

        System.out.println(encoder.matches("admin123", hash));

    }
}