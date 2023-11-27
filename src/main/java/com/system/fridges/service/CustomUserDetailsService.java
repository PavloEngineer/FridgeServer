package com.system.fridges.service;


import com.system.fridges.models.User;
import com.system.fridges.models.enam.UserType;
import com.system.fridges.repositories.UserRepository;
import com.system.fridges.security.CustomAuthority;
import com.system.fridges.security.PasswordHashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        this.user = user;
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

    public User getUser() {
        return user;
    }
}
