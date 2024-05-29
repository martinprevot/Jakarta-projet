package com.API.TP.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .dispatcherTypeMatchers(HttpMethod.valueOf("/users/**")).hasRole("ADMIN")
                                .dispatcherTypeMatchers(HttpMethod.valueOf("/tickets/**")).authenticated()
                                .anyRequest().permitAll()
                )
                .formLogin(withDefaults());
        return http.build();
    }
}
