package com.system.fridges.service;


import com.system.fridges.models.entities.User;
import com.system.fridges.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getHashPassword(),
                // Тут ви можете вказати ролі користувача. Наприклад, якщо у вас є поле roles у класі User:
                // user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                // Де roles - це колекція ролей користувача.
                Collections.emptyList()
        );
    }
}
