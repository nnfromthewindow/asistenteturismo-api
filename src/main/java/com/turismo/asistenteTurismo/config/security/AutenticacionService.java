package com.turismo.asistenteTurismo.config.security;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.turismo.asistenteTurismo.controller.form.LoginForm;
import com.turismo.asistenteTurismo.model.Usuario;
import com.turismo.asistenteTurismo.repository.UsuarioRepository;

@Service
public class AutenticacionService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	/*
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	*/
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
		return usuario.orElseThrow(() -> new UsernameNotFoundException("Datos inválidos"));
	}
	/*
	public String autenticarConToken(@Valid LoginForm loginForm) {
		Authentication datosLogin = loginForm.convertir();
		Authentication authentication = authManager.authenticate(datosLogin);
		return tokenService.generarToken(authentication);
	}
*/
}
 