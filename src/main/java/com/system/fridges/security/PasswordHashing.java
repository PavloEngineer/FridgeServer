package com.system.fridges.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashing {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean isSamePassword(String password, String passwordHash) {
        return passwordEncoder.matches(password, passwordHash);
    }
}
