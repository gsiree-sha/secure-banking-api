package com.sireesha.securebankingapi.config;

import com.sireesha.securebankingapi.security.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.Customizer;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/h2-console/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/api/users", "/api/users/", "/api/users/**").permitAll()
            .anyRequest().authenticated()
        )
        .userDetailsService(customUserDetailsService)
        .formLogin(form -> form.disable())
        .exceptionHandling(ex -> ex.authenticationEntryPoint(noPopupEntryPoint()))
        .httpBasic(Customizer.withDefaults());

    return http.build();
}


    @Bean
    public AuthenticationEntryPoint noPopupEntryPoint() {
        return (request, response, authException) -> {
            response.setHeader("WWW-Authenticate", "");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"Unauthorized\"}");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
