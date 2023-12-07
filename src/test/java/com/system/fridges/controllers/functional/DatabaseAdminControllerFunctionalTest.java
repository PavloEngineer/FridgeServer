package com.system.fridges.controllers.functional;


import com.system.fridges.models.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DatabaseAdminControllerFunctionalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void restoreDatabaseReturnsForbidden() {
        // Arrange
        String backupPathHash = "exampleBackupPathHash";

        // Act
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/databaseAdmin/restore?backupPathHash={backupPathHash}", null, String.class, backupPathHash);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void backupDatabaseReturnsForbidden() {
        // Arrange
        String backupPathHash = "exampleBackupPathHash";

        // Act
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/databaseAdmin/backup?backupPathHash={backupPathHash}", null, String.class, backupPathHash);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void addFridgesReturnsForbidden() {
        // Arrange
        List<Fridge> fridges = new ArrayList<>();
        // Add Fridge objects to the list

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/addFridges", fridges, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void addUserReturnsForbidden() {
        // Arrange
        List<User> users = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/addUsers", users, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void addSubscriptionReturnsForbidden() {
        // Arrange
        List<Subscription> subscriptions = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/addSubscription", subscriptions, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void addModelReturnsForbidden() {
        // Arrange
        List<Model> models = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/addModel", models, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void addOfficeReturnsForbidden() {
        // Arrange
        List<Office> offices = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/addOffice", offices, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void addAccessReturnsForbidden() {
        // Arrange
        List<Access> accesses = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/addAccess", accesses, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void addProductReturnsForbidden() {
        // Arrange
        List<Product> products = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/addProduct", products, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void addOrderReturnsForbidden() {
        // Arrange
        List<AutoOrder> autoOrders = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/addAutoOrder", autoOrders, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void addTransactionReturnsForbidden() {
        // Arrange
        List<Transaction> transactions = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/addTransaction", transactions, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void addFoodReturnsForbidden() {
        // Arrange
        List<Food> food = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/addFood", food, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void deleteFridgesReturnsForbidden() {
        // Arrange
        List<Fridge> fridges = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/deleteFridges", fridges, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void deleteUserReturnsForbidden() {
        // Arrange
        List<User> users = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/deleteUsers", users, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void deleteSubscriptionReturnsForbidden() {
        // Arrange
        List<Subscription> users = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/deleteSubscription", users, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void deleteModelReturnsForbidden() {
        // Arrange
        List<Model> models = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/deleteModel", models, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void deleteOfficeReturnsForbidden() {
        // Arrange
        List<Office> offices = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/deleteOffice", offices, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void deleteAccessReturnsForbidden() {
        // Arrange
        List<Access> accesses = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/deleteAccess", accesses, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void deleteProductReturnsForbidden() {
        // Arrange
        List<Product> products = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/deleteProduct", products, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void deleteOrderReturnsForbidden() {
        // Arrange
        List<AutoOrder> autoOrders = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/deleteAutoOrder", autoOrders, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void deleteTransactionReturnsForbidden() {
        // Arrange
        List<Transaction> transactions = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/deleteTransaction", transactions, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void deleteFoodReturnsForbidden() {
        // Arrange
        List<Food> food = new ArrayList<>();

        // Act
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/databaseAdmin/deleteFood", food, Void.class);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void getAllUsersReturnsForbidden() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "/businessAdmin/allUsers",
                String.class);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void getAllAccessReturnsForbidden() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "/businessAdmin/allAccess",
                String.class);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void getAllOfficeReturnsForbidden() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "/businessAdmin/allOffice",
                String.class);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void getAllModelReturnsForbidden() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "/businessAdmin/allModel",
                String.class);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void getAllSubscriptionReturnsForbidden() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "/businessAdmin/allSubscription",
                String.class);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void getAllOrderReturnsForbidden() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "/businessAdmin/allAutoOrder",
                String.class);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void getAllProductReturnsForbidden() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "/businessAdmin/allProduct",
                String.class);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void getAllFoodReturnsForbidden() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "/businessAdmin/allFood",
                String.class);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void getAllTransactionReturnsForbidden() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "/businessAdmin/allTransaction",
                String.class);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }
}
