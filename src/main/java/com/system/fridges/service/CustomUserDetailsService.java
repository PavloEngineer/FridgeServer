package com.system.fridges.service;


import com.example.webrent.repositories.UserConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {



    private BCryptPasswordEncoder passwordEncoder;

    public CustomUserDetailsService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Генерація рандомних значень для прикладу
        String randomPassword = null;
        System.out.println("User");
        try {
            randomPassword = UserConnection.getUserPassword(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User");

        long randomUserId = 1;

        // Закодувати введений пароль
        String encodedPassword = passwordEncoder.encode(randomPassword);


        // Повернення UserDetails об'єкту з рандомними даними про користувача
        return new org.springframework.security.core.userdetails.User(
                username,
                encodedPassword,
                Collections.emptyList()
        );
    }
}
