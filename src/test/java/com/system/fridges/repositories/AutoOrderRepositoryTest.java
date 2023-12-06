package com.system.fridges.repositories;


import com.system.fridges.models.transferObjects.fridgeObjects.FridgeOrder;
import com.system.fridges.models.transferObjects.userObjects.UserOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AutoOrderRepositoryTest {

    @Autowired
    private AutoOrderRepository autoOrderRepository;

    @Test
    @Transactional
    public void getInfoOrdersForFridgeByIdTest() {
        // Arrange
        int fridgeId = 1;

        // Act
        List<FridgeOrder> fridgeOrders = autoOrderRepository.getInfoOrdersForFridgeById(fridgeId);

        // Assert
        assertNotNull(fridgeOrders);
    }

    @Test
    @Transactional
    public void getInfoOrdersByIdWithNonFridgeTest() {
        // Arrange
        int nonExistingFridgeId = -1;

        // Act
        List<FridgeOrder> fridgeOrders = autoOrderRepository.getInfoOrdersForFridgeById(nonExistingFridgeId);

        // Assert
        assertNotNull(fridgeOrders);
        assertEquals(0, fridgeOrders.size(), "For a non-existing fridge, the list should be empty");
    }

    @Test
    @Transactional
    public void getAllOrdersForUserByIdTest() {
        // Arrange
        int userId = 1;

        // Act
        List<UserOrder> userOrders = autoOrderRepository.getAllOrdersForUserById(userId);

        // Assert
        assertNotNull(userOrders);
    }

    @Test
    @Transactional
    public void getAllOrdersForUserByIdWithNonUserTest() {
        // Arrange
        int nonExistingUserId = -1;

        // Act
        List<UserOrder> userOrders = autoOrderRepository.getAllOrdersForUserById(nonExistingUserId);

        // Assert
        assertNotNull(userOrders);
        assertEquals(0, userOrders.size(), "For a non-existing user, the list should be empty");
    }
}
