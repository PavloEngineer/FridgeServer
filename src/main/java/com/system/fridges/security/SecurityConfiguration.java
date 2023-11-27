package com.system.fridges.security;


import com.system.fridges.models.enam.UserType;
import com.system.fridges.service.UserServiceImpl;
import com.system.fridges.service.interfaces.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.io.IOException;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration  {

    private final UserServiceImpl userDetailsService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(); // Створіть свій фільтр для обробки токенів JWT
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(withDefaults())
                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/user/**").hasRole(UserType.REGULAR_USER.toString())
                        .requestMatchers("/user/**").hasRole(UserType.REGULAR_USER.toString())
                        .requestMatchers("/admin1/**").hasRole("ADMIN1")
                        .requestMatchers("/admin2/**").hasRole("ADMIN2")
                        .requestMatchers("/authentication/**").permitAll()
//                        .anyRequest().permitAll()
                )
                .formLogin(withDefaults())
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(customFilter(), JwtAuthenticationFilter.class)
                .build();
    }

    private OncePerRequestFilter customFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                if (request.getRequestURI().equals("/user/**") && !request.isUserInRole(UserType.REGULAR_USER.toString())) {
                    response.sendRedirect("/login"); // TODO: change for auto
                } else if (request.getRequestURI().equals("/admin1/**") && !request.isUserInRole(UserType.ADMIN_TYPE1.toString())) {
                    response.sendRedirect("/login"); // TODO: change for auto
                } else if (request.getRequestURI().equals("/admin2/**") && !request.isUserInRole(UserType.ADMIN_TYPE2.toString())) {
                    response.sendRedirect("/login"); // TODO: change for auto
                } else {
                    filterChain.doFilter(request, response);
                }
            }
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }



    public SecurityConfiguration(UserServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

