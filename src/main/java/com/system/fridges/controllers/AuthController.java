package com.system.fridges.controllers;

import com.system.fridges.models.User;
import com.system.fridges.models.transferObjects.JwtAuthenticationResponse;
import com.system.fridges.models.transferObjects.RefreshTokenRequest;
import com.system.fridges.models.transferObjects.userObjects.SignInRequest;
import com.system.fridges.service.AuthenticationServiceImpl;
import com.system.fridges.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/authentication")
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AuthenticationServiceImpl authenticationService;


    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthenticationResponse> singIn(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(userService.signIn(signInRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }


    @PostMapping("/register")
    public void registerUser(@RequestBody User user, @RequestParam("file") MultipartFile file) {
        userService.saveUser(user, file);
    }
}
