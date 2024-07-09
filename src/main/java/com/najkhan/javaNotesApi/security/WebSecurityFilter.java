package com.najkhan.javaNotesApi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.DefaultSecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
//@EnableWebSecurity
public class WebSecurityFilter {

    @Bean
    @Order(1)
    public DefaultSecurityFilterChain webSecurityCustomizerHealth(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((request) -> request
                        .requestMatchers(GET,"health")
                        .permitAll()
                        .requestMatchers("/**")
                        .authenticated()

                ).formLogin(withDefaults()).build();

    }
}

