package com.kirti.employee_management_system.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    // Secret Key (Use application.properties in production)
    private static final String JWT_SECRET =
            "EmployeeManagementSystemSecretKeyForJwtAuthentication2026";

    // Token Expiration Time (24 Hours)
    private static final long JWT_EXPIRATION = 24 * 60 * 60 * 1000;

    // Generate Secret Key
    private final Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes());

    // Generate JWT Token
    public String generateToken(String username) {

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract Username From Token
    public String getUsernameFromToken(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // Validate Token
    public boolean validateToken(String token) {

        try {

            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return true;

        } catch (Exception ex) {

            return false;

        }
    }
}