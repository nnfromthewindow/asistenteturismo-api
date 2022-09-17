package com.turismo.asistenteTurismo.controller;

import javax.validation.Valid;

import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.asistenteTurismo.config.security.TokenService;
import com.turismo.asistenteTurismo.controller.dto.TokenDTO;
import com.turismo.asistenteTurismo.controller.form.LoginForm;
import com.turismo.asistenteTurismo.repository.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {
	
    
	private AuthenticationManagerBuilder authenticationManagerBuilder;
    
	private UsuarioRepository usuarioRepository;
	
	private TokenService tokenService;

	public AutenticacionController(AuthenticationManagerBuilder authenticationManagerBuilder,
			UsuarioRepository usuarioRepository, TokenService tokenService) {
		this.authenticationManagerBuilder = authenticationManagerBuilder;
		this.usuarioRepository = usuarioRepository;
		this.tokenService = tokenService;
	}
	
	 @PostMapping
	 public ResponseEntity<Object> login(@Valid @RequestBody LoginForm loginForm, BindingResult bidBindingResult){
	        if(bidBindingResult.hasErrors())
	            return new ResponseEntity<>(new Message("Revise sus credenciales", null, true), HttpStatus.BAD_REQUEST);
	        try {
	                UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword());
	                Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	                String jwt = tokenService.generarToken(authentication);
	                TokenDTO jwtDto = new TokenDTO(jwt);
	                return new ResponseEntity<>(jwtDto, HttpStatus.OK);
	        } catch (Exception e) {
	                return new ResponseEntity<>(new Message("Revise sus credenciales",null, true), HttpStatus.BAD_REQUEST);
	        }
	    }
    
	
	
}
