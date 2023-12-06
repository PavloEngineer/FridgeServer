package com.system.fridges.repositories;

import com.system.fridges.models.Access;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccessRepositoryFunctionalTest {

    @Autowired
    private AccessRepository accessRepository;

    @Test
    @Transactional
    public void findAllAccessForUserByIdTest() {
        // Arrange
        int userId = 1;

        // Act
        List<Access> accessList = accessRepository.findAllAccessForUserById(userId);

        // Assert
        assertNotNull(accessList);
    }

    @Test
    @Transactional
    public void testFindAllAccessForUserByIdWithNonExistingUser() {
        // Arrange
        int nonExistingUserId = -1;

        // Act
        List<Access> accessList = accessRepository.findAllAccessForUserById(nonExistingUserId);

        // Assert
        assertNotNull(accessList);
        assertEquals(0, accessList.size(), "For a non-existing user, the list should be empty");
    }
}
