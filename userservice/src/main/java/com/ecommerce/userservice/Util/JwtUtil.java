package com.ecommerce.userservice.Util;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Generate a secure random 256-bit key
    private String secret = "secretkey@ECOMMERCE"; // fixed secret


      private long expiration = 900000;

    // 1. Generate a JWT token for a user
    public String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)                    // "sub" claim → user identifier
                .claim("role", role)                  // custom claim → role
                .setIssuedAt(new Date())              // issued at (iat)
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // expiry (exp)
                .signWith(SignatureAlgorithm.HS256, secret) // sign with secret key
                .compact();
    }
}