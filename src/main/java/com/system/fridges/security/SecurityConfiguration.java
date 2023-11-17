package com.system.fridges.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.io.IOException;
import static org.springframework.security.config.Customizer.withDefaults;

//@Configuration
//public class SecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/authentication").permitAll()
//                        .requestMatchers("/code").permitAll()
////                        .requestMatchers("/listAdvers").permitAll()
//                        .requestMatchers("/password").permitAll()
//                        .requestMatchers("/registration").permitAll()
//                                .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
//                                .requestMatchers("/sellerForm/listAdversS").permitAll()
//                        .requestMatchers("/listAdvers").hasRole("USER")
//                        .anyRequest().permitAll()
//                )
//                .formLogin(withDefaults())
//                .addFilterBefore(customFilter(), UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//
//    private OncePerRequestFilter customFilter() {
//        return new OncePerRequestFilter() {
//            @Override
//            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//                if (request.getRequestURI().equals("/listAdvers") && !request.isUserInRole("USER")) {
//                    response.sendRedirect("/authentication");
//                } else {
//                    filterChain.doFilter(request, response);
//                }
//            }
//        };
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    private final CustomUserDetailsService userDetailsService;
//
//    public SecurityConfiguration(CustomUserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//}

