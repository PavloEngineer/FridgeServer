package com.system.fridges.controllers.functional;



import com.system.fridges.models.transferObjects.foodObjects.FoodInFridge;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeOrder;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeTransactionHistory;
import com.system.fridges.repositories.AccessRepository;
import com.system.fridges.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FridgeControllerFunctionalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AccessRepository accessRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void getAllFoodReturnsValidResponse() {
        // Arrange
        int fridgeId = 1;

        // Act
        ResponseEntity<FoodInFridge[]> responseEntity = restTemplate.getForEntity( "/fridge/foodInside/{email}?fridgeId={fridgeId}",
                FoodInFridge[].class, "example@example.com", fridgeId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void getAutoOrderingReturnsValidResponse() {
        // Arrange
        int fridgeId = 1;

        // Act
        ResponseEntity<FridgeOrder[]> responseEntity = restTemplate.getForEntity("/fridge/autoOrdering/{email}?fridgeId={fridgeId}",
                FridgeOrder[].class, "example@example.com", fridgeId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void getTransactionHistoriesReturnsValidResponse() {
        // Arrange
        int fridgeId = 1;

        // Act
        ResponseEntity<FridgeTransactionHistory[]> responseEntity = restTemplate.getForEntity("/fridge/transactions?fridgeId={fridgeId}",
                FridgeTransactionHistory[].class, fridgeId);
        System.out.println(Arrays.toString(responseEntity.getBody()));

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void doInventorySendMessages() {
        // Arrange
        int fridgeId = 1;

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/fridge/inventory", fridgeId, Void.class);

        // Assert: Assuming a successful request (HttpStatus.OK)
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void doAutoOrderReturnsValidResponse() {
        // Arrange
        int fridgeId = 1;

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/fridge/doAutoOrder", fridgeId, Void.class);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}

