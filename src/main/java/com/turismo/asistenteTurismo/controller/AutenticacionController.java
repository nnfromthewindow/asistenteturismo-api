package com.turismo.asistenteTurismo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {
	
	
	
	@GetMapping
    public Map<String,Object> getPrincipalInfo(JwtAuthenticationToken principal) {
        
        Collection<String> authorities = principal.getAuthorities()
          .stream()
          .map(GrantedAuthority::getAuthority)
          .collect(Collectors.toList());
        
        Map<String,Object> info = new HashMap<>();
        info.put("name", principal.getName());
        info.put("authorities", authorities);
        info.put("tokenAttributes", principal.getTokenAttributes());
        
        return info;
    }
	/*
	@Autowired
	private AutenticacionService autenticacionService;
	
	@PostMapping
	public ResponseEntity<?> auth(@RequestBody @Valid LoginForm loginForm) {
		try {
			String token = autenticacionService.autenticarConToken(loginForm);
			return ResponseEntity.ok(new TokenDTO(token, "Bearer "));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
*/
}
