package com.tranvuhoang.demo.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tranvuhoang.demo.log.InjectLogger;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
	
	private static @InjectLogger Logger logger;
	
	@Value("${jwt.secret}")
	private String secret;
	
	private final String subject = "venus";
	private final long expireAfterYears = 10*365*24*60*60;
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	public String generateJwt() {
		Map<String, Object> claims = new HashMap<>();
		String t = (new GeneraterUtil()).generateCurrentUnixTime();
		claims.put("unix_timestamp", t);
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + expireAfterYears * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public boolean verifyJwt(String token) {
		Date expireDt = getClaimFromToken(token, Claims::getExpiration);
		logger.info("token expire at: {}", expireDt.toString());
		String subject = getClaimFromToken(token, Claims::getSubject);
		return subject.equals(this.subject);
	}

}
