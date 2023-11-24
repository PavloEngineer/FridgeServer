package com.system.fridges.service;


import com.system.fridges.models.User;
import com.system.fridges.repositories.UserRepository;
import com.system.fridges.security.PasswordHashing;
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
//        User user = userRepository.findById(Integer.valueOf(username)).get();
        User user = userRepository.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                String.valueOf(user.getUserId()),
                user.getHashPassword(),
                // Тут ви можете вказати ролі користувача. Наприклад, якщо у вас є поле roles у класі User:
                // user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                // Де roles - це колекція ролей користувача.
                Collections.emptyList()
        );
    }
}
