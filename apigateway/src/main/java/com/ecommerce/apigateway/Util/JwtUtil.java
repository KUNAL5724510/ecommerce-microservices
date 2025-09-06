package com.ecommerce.apigateway.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Must match UserService secret
    private String secret = "secretkey@ECOMMERCE";

    // 1. Validate token (check signature + expiry)
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token); // will throw if expired or invalid
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 2. Extract email (from "sub" claim)
    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    // 3. Extract role (from custom "role" claim)
    public String extractRole(String token) {
        return (String) getClaims(token).get("role");
    }

    // Helper → get all claims
    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
