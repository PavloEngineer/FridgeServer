package com.system.fridges.controllers;

import com.system.fridges.models.AutoOrder;
import com.system.fridges.models.Food;
import com.system.fridges.models.transferObjects.foodObjects.FoodInFridge;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeOrder;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeTransactionHistory;
import com.system.fridges.service.FridgeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FridgeControllerTest {

    @InjectMocks
    private FridgeController fridgeController;

    @Mock
    private FridgeServiceImpl fridgeService;


    @Test
    void getAllFoodReturnsValidResponse() {
        // Arrange
        int fridgeId = 1;

        // Act
        ResponseEntity<List<FoodInFridge>> responseEntity = fridgeController.getAllFood(fridgeId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(fridgeService, times(1)).getFoodInFridgeById(fridgeId);
    }

    @Test
    void getAutoOrderingReturnsValidResponse() {
        // Arrange
        int fridgeId = 1;
        String email = "example@example.com";

        // Act
        ResponseEntity<List<FridgeOrder>> responseEntity = fridgeController.getAutoOrdering(fridgeId, email);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(fridgeService, times(1)).getAutoOrdersById(fridgeId, email);
    }

    @Test
    void getTransactionHistoriesReturnsValidResponse() {
        // Arrange
        int fridgeId = 1;

        // Act
        ResponseEntity<List<FridgeTransactionHistory>> responseEntity = fridgeController.getTransactionHistories(fridgeId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(fridgeService, times(1)).getTransactionHistoryById(fridgeId);
    }

    @Test
    void doInventoryReturnsValidResponse() {
        // Arrange
        int fridgeId = 1;

        // Act
        fridgeController.doInventory(fridgeId);

        // Assert
        verify(fridgeService, times(1)).doInventoryForFridge(fridgeId);
    }

    @Test
    void doAutoOrderReturnsValidResponse() {
        // Arrange
        int fridgeId = 1;

        // Act
        fridgeController.doAutoOrder(fridgeId);

        // Assert
        verify(fridgeService, times(1)).doAutoOrdering(fridgeId);
    }
}

