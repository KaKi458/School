package com.school.security;

import com.school.exception.SchoolApiException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expiration}")
    private String jwtExpiration;

    private UserDetailsService userDetailsService;

    public JwtToken generateToken(Authentication authentication) {

        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + Long.parseLong(jwtExpiration));

        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(key())
                .compact();

        return new JwtToken(jwtToken);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parse(token);
            return true;
        } catch (MalformedJwtException ex) {
            throw new SchoolApiException(HttpStatus.BAD_REQUEST, "Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new SchoolApiException(HttpStatus.BAD_REQUEST, "Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new SchoolApiException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new SchoolApiException(HttpStatus.BAD_REQUEST, "JWT claims string is empty.");
        }
    }

    public UserDetails getUserDetails(String jwtToken) {
        String username = getUsername(jwtToken);
        return userDetailsService.loadUserByUsername(username);
    }

    private Claims extractClaims(String jwtToken) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();

        return claims;
    }

    private String getUsername(String jwtToken) {
        Claims claims = extractClaims(jwtToken);
        String username = claims.getSubject();

        return username;
    }

    private Key key() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret));
    }
}
