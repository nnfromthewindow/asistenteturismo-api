package com.turismo.asistenteTurismo.controller.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class LoginForm {
	

	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public Authentication convertir() {
		return new UsernamePasswordAuthenticationToken(username, password);
	}

}
