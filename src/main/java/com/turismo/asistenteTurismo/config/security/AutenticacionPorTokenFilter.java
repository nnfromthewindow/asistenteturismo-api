package com.turismo.asistenteTurismo.config.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.turismo.asistenteTurismo.model.Usuario;
import com.turismo.asistenteTurismo.repository.UsuarioRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public class AutenticacionPorTokenFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperarToken(request);

		validaAndAutenticaUsuario(token);
		
		filterChain.doFilter(request, response);
	
	}
	private void validaAndAutenticaUsuario(String token) {
		
		Optional<Jws<Claims>> optClaims = tokenService.getTokenInfo(token);
		
		optClaims.ifPresent(claims -> {
			
			long idUsuario = Long.parseLong(claims.getBody().getSubject());
			
			Usuario usuario = usuarioRepository.findById(idUsuario).get();
			
			UsernamePasswordAuthenticationToken autenticacionPorToken = new UsernamePasswordAuthenticationToken(usuario,
					null, usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(autenticacionPorToken);
		});
	}

	private String recuperarToken(HttpServletRequest request) {
		String tokenHeader = request.getHeader("Authorization");
		String comienzoToken = "Bearer ";
		
		if (tokenHeader == null || tokenHeader.isEmpty() || !tokenHeader.startsWith(comienzoToken)) {
			return null;
		}
		
		return tokenHeader.substring(comienzoToken.length() , tokenHeader.length());
	}

}
