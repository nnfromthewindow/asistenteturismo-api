package com.turismo.asistenteTurismo.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
            		.antMatchers(HttpMethod.GET,"/establecimiento").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic();
        return http.build();
    }
    

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers( "/h2-console/**","/v3/api-docs",
				"/v2/api-docs",
				"/swagger-resources/**", 
				"/swagger-ui/**");
    }
}
