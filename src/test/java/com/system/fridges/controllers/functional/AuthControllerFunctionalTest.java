package com.system.fridges.controllers.functional;

import com.system.fridges.models.transferObjects.JwtAuthenticationResponse;
import com.system.fridges.models.transferObjects.RefreshTokenRequest;
import com.system.fridges.models.transferObjects.userObjects.SignInRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthControllerFunctionalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void signInCorrectAuthentication() {
        // Arrange
        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setEmail("pasakan2@gmail.com");
        signInRequest.setPassword("1234");

        // Act
        ResponseEntity<JwtAuthenticationResponse> responseEntity = restTemplate.postForEntity("/authentication/signIn", signInRequest, JwtAuthenticationResponse.class);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add more assertions as needed
    }

    @Test
    void refreshGetException() {
        // Arrange
        RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest();
        refreshTokenRequest.setToken("413F442847284862506553685660597033733676397924422645294848406351");

        // Act
        ResponseEntity<JwtAuthenticationResponse> responseEntity = restTemplate.postForEntity("/authentication/refresh", refreshTokenRequest, JwtAuthenticationResponse.class);
        // Act and Assert

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }
}
