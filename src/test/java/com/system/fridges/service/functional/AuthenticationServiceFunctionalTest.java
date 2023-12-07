package com.system.fridges.service.functional;


import com.system.fridges.models.transferObjects.authenticationObjects.JwtAuthenticationResponse;
import com.system.fridges.models.transferObjects.authenticationObjects.RefreshTokenRequest;
import com.system.fridges.service.AuthenticationServiceImpl;
import com.system.fridges.service.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthenticationServiceFunctionalTest {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Test
    void extractUserNameReturnsEmail() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXNha2FuZTk5MEBnbWFpbC5jb20iLCJpYXQiOjE3MDE3NjI4OTcsImV4cCI6MTcwMTc2NDMzN30.7cjS492anBC_hrMs0P6mu7bYTnnjf2ZBfwKHOP7WdGk";
        String username = "pasakane990@gmail.com";

        String result = authenticationService.extractUserName(token);

        assertEquals(username, result);
    }

    @Test
    void refreshTokenTest() {
        String refreshToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXNha2FuZTk5MEBnbWFpbC5jb20iLCJpYXQiOjE3MDE3MTkxNzQsImV4cCI6MTcwMjMyMzk3NH0.m8H6bDXKCjD96TzUKh1_A3Pe8b4avtwFk9avanubE7Y";
        RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest();
        refreshTokenRequest.setToken(refreshToken);

        JwtAuthenticationResponse result = authenticationService.refreshToken(refreshTokenRequest);

        assertNotNull(result);
    }

    @Test
    void isTokenValidTest() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXNha2FuZTk5MEBnbWFpbC5jb20iLCJpYXQiOjE3MDE3NjI4OTcsImV4cCI6MTcwMTc2NDMzN30.7cjS492anBC_hrMs0P6mu7bYTnnjf2ZBfwKHOP7WdGk";
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                "pasakane990@gmail.com",
                "1234",
                Collections.emptyList()
        );

        boolean result = authenticationService.isTokenValid(token, userDetails);

        assertTrue(result);
    }
}
