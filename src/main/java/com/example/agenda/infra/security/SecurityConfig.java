package com.example.agenda.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    private CustomUserDetailsService userDetailsService;

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/times").permitAll()
                        .requestMatchers(HttpMethod.POST, "/times").permitAll()
                        .requestMatchers(HttpMethod.POST, "/admin").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/admin/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/admin").permitAll()
                        .requestMatchers(HttpMethod.GET, "/admin").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/appointments").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/appointments/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/appointments/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/appointments").permitAll()
                        .requestMatchers(HttpMethod.GET, "/appointments/porID").permitAll()
                        .requestMatchers(HttpMethod.GET, "/availability").permitAll()
                        .requestMatchers(HttpMethod.GET, "/services").permitAll()
                        .requestMatchers(HttpMethod.POST, "/services").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/services/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/services/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/client").permitAll()
                        .requestMatchers(HttpMethod.GET, "/client").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/users/{id}").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/users/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/professional").permitAll()
                        .requestMatchers(HttpMethod.GET, "/professional/porID/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/professional/{id}").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/professional/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/professional").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
