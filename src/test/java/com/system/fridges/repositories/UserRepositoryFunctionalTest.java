package com.system.fridges.repositories;


import com.system.fridges.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryFunctionalTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserByEmail() {
        // Arrange
        String userEmail = "pasakane990@gmail.com";

        // Act
        Optional<User> userOptional = userRepository.findUserByEmail(userEmail);

        // Assert
        assertTrue(userOptional.isPresent());
        User user = userOptional.get();
        assertEquals(userEmail, user.getEmail());
    }
}
