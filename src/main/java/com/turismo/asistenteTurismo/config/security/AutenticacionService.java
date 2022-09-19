package com.turismo.asistenteTurismo.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.turismo.asistenteTurismo.model.Usuario;
import com.turismo.asistenteTurismo.repository.UsuarioRepository;

@Service
public class AutenticacionService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
		return usuario.orElseThrow(() -> new UsernameNotFoundException("Datos inválidos"));
	}

}
 