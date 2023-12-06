package com.system.fridges.repositories;

import com.system.fridges.models.transferObjects.foodObjects.FoodInFridge;
import com.system.fridges.models.transferObjects.foodObjects.SpoiledFood;
import com.system.fridges.models.transferObjects.userObjects.UserFood;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FoodRepositoryFunctionalTest {

    @Autowired
    private FoodRepository foodRepository;

    @Test
    @Transactional
    public void getAllFoodUserByIdTest() {
        // Arrange
        int userId = 1;

        // Act
        List<UserFood> userFoods = foodRepository.getAllFoodUserById(userId);

        // Assert
        assertNotNull(userFoods);
    }

    @Test
    @Transactional
    public void getAllFoodUserByIdWithNonUserTest() {
        // Arrange
        int nonExistingUserId = -1;

        // Act
        List<UserFood> userFoods = foodRepository.getAllFoodUserById(nonExistingUserId);

        // Assert
        assertNotNull(userFoods);
        assertEquals(0, userFoods.size(), "For a non-existing user, the list should be empty");
    }

    @Test
    @Transactional
    public void getSpoiledFoodByFridgeIdTest() {
        // Arrange
        int fridgeId = 1;

        // Act
        List<SpoiledFood> spoiledFoods = foodRepository.getSpoiledFoodByFridgeId(fridgeId);

        // Assert
        assertNotNull(spoiledFoods);
    }

    @Test
    @Transactional
    public void getSpoiledFoodByFridgeIdWithNonFridgeTest() {
        // Arrange
        int nonExistingFridgeId = -1;

        // Act
        List<SpoiledFood> spoiledFoods = foodRepository.getSpoiledFoodByFridgeId(nonExistingFridgeId);

        // Assert
        assertNotNull(spoiledFoods);
        assertEquals(0, spoiledFoods.size(), "For a non-existing fridge, the list should be empty");
    }

    @Test
    @Transactional
    public void getAllFoodForFridgeTest() {
        // Arrange
        int fridgeId = 1;

        // Act
        List<FoodInFridge> foodInFridges = foodRepository.getAllFoodForFridge(fridgeId);

        // Assert
        assertNotNull(foodInFridges);
    }

    @Test
    @Transactional
    public void getAllFoodForFridgeWithNonFridgeTest() {
        // Arrange
        int nonExistingFridgeId = -1;

        // Act
        List<FoodInFridge> foodInFridges = foodRepository.getAllFoodForFridge(nonExistingFridgeId);

        // Assert
        assertNotNull(foodInFridges);
        assertEquals(0, foodInFridges.size(), "For a non-existing fridge, the list should be empty");
    }
}
