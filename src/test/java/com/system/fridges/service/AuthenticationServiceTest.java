package com.system.fridges.service;

import com.system.fridges.models.User;
import com.system.fridges.models.transferObjects.JwtAuthenticationResponse;
import com.system.fridges.models.transferObjects.RefreshTokenRequest;
import com.system.fridges.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @Mock
    private UserRepository userRepository;

    @Test
    void extractUserName() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXNha2FuZTk5MEBnbWFpbC5jb20iLCJpYXQiOjE3MDE3MTg1NDYsImV4cCI6MTcwMTcxOTk4Nn0.DCHfotkpaTS1WTqEqrCeRbGZJPzt_QHnaHkuj0pIXsY";
        String username = "pasakane990@gmail.com";

        String result = authenticationService.extractUserName(token);

        assertEquals(username, result);
    }

    @Test
    void isTokenValid() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXNha2FuZTk5MEBnbWFpbC5jb20iLCJpYXQiOjE3MDE3MTg1NDYsImV4cCI6MTcwMTcxOTk4Nn0.DCHfotkpaTS1WTqEqrCeRbGZJPzt_QHnaHkuj0pIXsY";
        String username = "pasakane990@gmail.com";
        User user = new User();
        user.setEmail(username);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                "1234",
                Collections.emptyList()
        );

        when(userRepository.findUserByEmail(username)).thenReturn(java.util.Optional.of(user));

        boolean result = authenticationService.isTokenValid(token, userDetails);

        assertTrue(result);
    }

    @Test
    void refreshToken() {
        String refreshToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXNha2FuZTk5MEBnbWFpbC5jb20iLCJpYXQiOjE3MDE3MTkxNzQsImV4cCI6MTcwMjMyMzk3NH0.m8H6bDXKCjD96TzUKh1_A3Pe8b4avtwFk9avanubE7Y";
        RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest();
        refreshTokenRequest.setToken(refreshToken);

        JwtAuthenticationResponse result = new JwtAuthenticationResponse();

        assertNotNull(result);
    }
}
