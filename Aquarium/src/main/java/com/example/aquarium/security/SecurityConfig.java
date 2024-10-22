package com.example.aquarium.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/**").permitAll()
//                .requestMatchers("/api/auth/**").permitAll()
//                .requestMatchers("/api/events/**").permitAll()
//                .requestMatchers(HttpMethod.POST, "/api/events/**").hasAuthority("EVENT_CREATE")
//                .requestMatchers(HttpMethod.PUT, "/api/events/**").hasAuthority("EVENT_UPDATE")
//                .requestMatchers(HttpMethod.DELETE, "/api/events/**").hasAuthority("EVENT_DELETE")
                .anyRequest().authenticated();
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // Thêm các bean khác như UserDetailsService, PasswordEncoder nếu cần
}

