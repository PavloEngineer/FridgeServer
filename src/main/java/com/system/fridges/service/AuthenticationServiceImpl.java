package com.system.fridges.service;

import com.system.fridges.models.User;
import com.system.fridges.models.enam.UserType;
import com.system.fridges.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationServiceImpl {

    @Autowired
    private HttpSession session;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    // TODO: change name of function
    public User doAuthentication(String password, String email) {

        // Визначення типу користувача
        UserServiceImpl userService = new UserServiceImpl();
        return userService.findUserByEmail(email);

    }
}
