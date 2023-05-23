package com.arul.restaurantmanagement.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpirationMs;

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        SecretKey secretKey = generateSecretKey();

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    private SecretKey generateSecretKey() {
        byte[] decodedKey = Base64.getDecoder().decode(jwtSecret);
        return new SecretKeySpec(decodedKey, SignatureAlgorithm.HS512.getJcaName());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(generateSecretKey())
                    .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        Map<String, Object> allClaims = extractAllClaims(token);
        Claims claims = Jwts.claims(allClaims);

        return claimsResolver.apply(claims);
    }

    public Map<String, Object> extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(generateSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromToken(String token) {
        return extractClaims(token, Claims::getSubject);
    }
}
