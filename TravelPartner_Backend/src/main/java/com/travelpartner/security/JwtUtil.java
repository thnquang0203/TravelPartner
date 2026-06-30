package com.travelpartner.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
	private String jwtSecret;
	private long jwtExpiration;
	private SecretKey getKey() {
		return Keys.hmacShaKeyFor(jwtSecret.getBytes());
	}
	public String taoToken(String email, String vaiTro) {
		return Jwts.builder().subject(email)
				.claim("vaiTro", vaiTro)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis()+ jwtExpiration))
				.signWith(getKey())
				.compact();
	}
	public String layEmailTuToken(String token) {
		return Jwts.parser()
				.verifyWith(getKey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	public boolean kiemTraHopLe(String token) {
		try {
			Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			// TODO: handle exception
			return false;
		}
	}
}
