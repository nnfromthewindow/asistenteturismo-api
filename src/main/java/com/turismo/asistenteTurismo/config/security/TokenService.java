package com.turismo.asistenteTurismo.config.security;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.turismo.asistenteTurismo.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Service
public class TokenService {
	
	@Value("${asistenteTurismo.jwt.expirationTime}")
	private Long expirationTime;
	
	@Value("${asistenteTurismo.jwt.secret}")
	private String secret;
	
	@Value("${asistenteTurismo.jwt.issuer}")
	private String issuer;

	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	public String generarToken(Authentication authentication){
		

		LocalDateTime ahora = LocalDateTime.now();
		LocalDateTime expiracion = ahora.plusMinutes(expirationTime);
	      
        Usuario mainUser = (Usuario) authentication.getPrincipal();
        return Jwts.builder().setSubject(mainUser.getId().toString())
        .setIssuedAt(Date.from(ahora.atZone(ZoneId.systemDefault()).toInstant()))
        .setExpiration(Date.from(expiracion.atZone(ZoneId.systemDefault()).toInstant()))
        .signWith(key)
        .compact();
    }

	public Optional<Jws<Claims>> getTokenInfo(String token) {
		try {
			
			Jws<Claims> claims = Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(token);
			
			return Optional.of(claims);
		} catch(Exception e) {
	
			return Optional.empty();
		}
	}

}
