package com.system.fridges.controllers;


import com.system.fridges.models.entities.*;
import com.system.fridges.service.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DatabaseAdminControllerTest {

    @Mock
    private AdminServiceImpl adminService;

    @InjectMocks
    private DatabaseAdminController databaseAdminController;

    @Test
    void restoreDatabaseReturnsValidResponse() {
        // Arrange
        String backupPath = "exampleBackupPathHash";
        byte[] backupPathHash = Base64.getEncoder().encode(backupPath.getBytes());
        Mockito.when(adminService.restoreDatabase(backupPathHash)).thenReturn(true);

        // Act
        ResponseEntity<Boolean> responseEntity = databaseAdminController.restoreDatabase(backupPathHash);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody());
    }

    @Test
    void backupDatabaseReturnsValidResponse() {
        // Arrange
        String backupPath = "exampleBackupPathHash";
        byte[] backupPathHash = Base64.getEncoder().encode(backupPath.getBytes());
        Mockito.when(adminService.doBackupDatabase(backupPathHash)).thenReturn(true);

        // Act
        ResponseEntity<Boolean> responseEntity = databaseAdminController.backupDatabase(backupPathHash);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody());
    }

    // Repeat similar tests for other methods

    @Test
    void addFridgesSuccessfulSave() {
        // Arrange
        List<Fridge> fridges = new ArrayList<>();

        // Act
        databaseAdminController.addFridges(fridges);

        // Assert
        Mockito.verify(adminService, times(1)).addFridges(fridges);
    }

    @Test
    void addUsersSuccessfulSave() {
        // Arrange
        List<User> user = new ArrayList<>();

        // Act
        databaseAdminController.addUsers(user);

        // Assert
        Mockito.verify(adminService, times(1)).addUser(user);
    }

    @Test
    void addSubscriptionSuccessfulSave() {
        // Arrange
        List<Subscription> subscription = new ArrayList<>();

        // Act
        databaseAdminController.addSubscriptions(subscription);

        // Assert
        Mockito.verify(adminService, times(1)).addSubscription(subscription);
    }

    @Test
    void addModelSuccessfulSave() {
        // Arrange
        List<Model> models = new ArrayList<>();

        // Act
        databaseAdminController.addModels(models);

        // Assert
        Mockito.verify(adminService, times(1)).addModel(models);
    }

    @Test
    void addOfficeSuccessfulSave() {
        // Arrange
        List<Office> office = new ArrayList<>();

        // Act
        databaseAdminController.addOffices(office);

        // Assert
        Mockito.verify(adminService, times(1)).addOffice(office);
    }

    @Test
    void addAccessSuccessfulSave() {
        // Arrange
        List<Access> accesses = new ArrayList<>();

        // Act
        databaseAdminController.addAccess(accesses);

        // Assert
        Mockito.verify(adminService, times(1)).addAccess(accesses);
    }

    @Test
    void addProductSuccessfulSave() {
        // Arrange
        List<Product> products = new ArrayList<>();

        // Act
        databaseAdminController.addProducts(products);

        // Assert
        Mockito.verify(adminService, times(1)).addProduct(products);
    }

    @Test
    void addOrdersSuccessfulSave() {
        // Arrange
        List<AutoOrder> orders = new ArrayList<>();

        // Act
        databaseAdminController.addAutoOrders(orders);

        // Assert
        Mockito.verify(adminService, times(1)).addAutoOrder(orders);
    }

    @Test
    void addTransactionSuccessfulSave() {
        // Arrange
        List<Transaction> transactions = new ArrayList<>();

        // Act
        databaseAdminController.addTransactions(transactions);

        // Assert
        Mockito.verify(adminService, times(1)).addTransaction(transactions);
    }

    @Test
    void addFoodSuccessfulSave() {
        // Arrange
        List<Food> food = new ArrayList<>();

        // Act
        databaseAdminController.addFood(food);

        // Assert
        Mockito.verify(adminService, times(1)).addFood(food);
    }

    @Test
    void deleteUserSuccessfulDelete() {
        // Arrange
        List<Integer> userIds = new ArrayList<>();

        // Act
        databaseAdminController.deleteUsers(userIds);

        // Assert
        Mockito.verify(adminService, times(1)).deleteUser(userIds);
    }

    @Test
    void deleteFridgesSuccessfulDelete() {
        // Arrange
        List<Integer> fridgesIds = new ArrayList<>();

        // Act
        databaseAdminController.deleteFridges(fridgesIds);

        // Assert
        Mockito.verify(adminService, times(1)).deleteFridge(fridgesIds);
    }

    @Test
    void deleteSubscriptionSuccessfulDelete() {
        // Arrange
        List<Integer> subscriptionIds = new ArrayList<>();

        // Act
        databaseAdminController.deleteSubscriptions(subscriptionIds);

        // Assert
        Mockito.verify(adminService, times(1)).deleteSubscription(subscriptionIds);
    }

    @Test
    void deleteModelSuccessfulDelete() {
        // Arrange
        List<Integer> modelIds = new ArrayList<>();

        // Act
        databaseAdminController.deleteModels(modelIds);

        // Assert
        Mockito.verify(adminService, times(1)).deleteModel(modelIds);
    }

    @Test
    void deleteOfficeSuccessfulDelete() {
        // Arrange
        List<Integer> officeIds = new ArrayList<>();

        // Act
        databaseAdminController.deleteOffices(officeIds);

        // Assert
        Mockito.verify(adminService, times(1)).deleteOffice(officeIds);
    }

    @Test
    void deleteAccessSuccessfulDelete() {
        // Arrange
        List<Integer> accessIds = new ArrayList<>();

        // Act
        databaseAdminController.deleteAccess(accessIds);

        // Assert
        Mockito.verify(adminService, times(1)).deleteAccess(accessIds);
    }

    @Test
    void deleteProductSuccessfulDelete() {
        // Arrange
        List<Integer> productIds = new ArrayList<>();

        // Act
        databaseAdminController.deleteProducts(productIds);

        // Assert
        Mockito.verify(adminService, times(1)).deleteProduct(productIds);
    }

    @Test
    void deleteOrderSuccessfulDelete() {
        // Arrange
        List<Integer> orderIds = new ArrayList<>();

        // Act
        databaseAdminController.deleteAutoOrders(orderIds);

        // Assert
        Mockito.verify(adminService, times(1)).deleteAutoOrder(orderIds);
    }

    @Test
    void deleteTransactionSuccessfulDelete() {
        // Arrange
        List<Integer> transactionIds = new ArrayList<>();

        // Act
        databaseAdminController.deleteTransactions(transactionIds);

        // Assert
        Mockito.verify(adminService, times(1)).deleteTransaction(transactionIds);
    }

    @Test
    void deleteFoodSuccessfulDelete() {
        // Arrange
        List<Integer> foodIds = new ArrayList<>();

        // Act
        databaseAdminController.deleteFood(foodIds);

        // Assert
        Mockito.verify(adminService, times(1)).deleteFood(foodIds);
    }


    @Test
    void getAllFridgesReturnsValidResponse() {
        when(adminService.getAllFridges()).thenReturn(new ArrayList<Fridge>());

        ResponseEntity<List<Fridge>> responseEntity = databaseAdminController.getAllFridges();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(adminService, times(1)).getAllFridges();
    }

    @Test
    void getAllUsersReturnsValidResponse() {
        when(adminService.getAllUsers()).thenReturn(new ArrayList<User>());

        ResponseEntity<List<User>> responseEntity = databaseAdminController.getAllUsers();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(adminService, times(1)).getAllUsers();
    }

    @Test
    void getAllAccessReturnsValidResponse() {
        when(adminService.getAllAccess()).thenReturn(new ArrayList<Access>());

        ResponseEntity<List<Access>> responseEntity = databaseAdminController.getAllAccess();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(adminService, times(1)).getAllAccess();
    }

    @Test
    void getAllOfficeReturnsValidResponse() {
        when(adminService.getAllOffice()).thenReturn(new ArrayList<Office>());

        ResponseEntity<List<Office>> responseEntity = databaseAdminController.getAllOffices();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(adminService, times(1)).getAllOffice();
    }

    @Test
    void getAllModelReturnsValidResponse() {
        when(adminService.getAllModel()).thenReturn(new ArrayList<Model>());

        ResponseEntity<List<Model>> responseEntity = databaseAdminController.getAllModels();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(adminService, times(1)).getAllModel();
    }

    @Test
    void getAllSubscriptionReturnsValidResponse() {
        when(adminService.getAllSubscription()).thenReturn(new ArrayList<Subscription>());

        ResponseEntity<List<Subscription>> responseEntity = databaseAdminController.getAllSubscriptions();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(adminService, times(1)).getAllSubscription();
    }

    @Test
    void getAllOrderReturnsValidResponse() {
        when(adminService.getAllOrder()).thenReturn(new ArrayList<AutoOrder>());

        ResponseEntity<List<AutoOrder>> responseEntity = databaseAdminController.getAllOrders();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(adminService, times(1)).getAllOrder();
    }

    @Test
    void getAllProductReturnsValidResponse() {
        when(adminService.getAllProduct()).thenReturn(new ArrayList<Product>());

        ResponseEntity<List<Product>> responseEntity = databaseAdminController.getAllProducts();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(adminService, times(1)).getAllProduct();
    }

    @Test
    void getAllFoodReturnsValidResponse() {
        when(adminService.getAllFood()).thenReturn(new ArrayList<Food>());

        ResponseEntity<List<Food>> responseEntity = databaseAdminController.getAllFood();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(adminService, times(1)).getAllFood();
    }

    @Test
    void getAllTransactionReturnsValidResponse() {
        when(adminService.getAllTransaction()).thenReturn(new ArrayList<Transaction>());

        ResponseEntity<List<Transaction>> responseEntity = databaseAdminController.getAllTransactions();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(adminService, times(1)).getAllTransaction();
    }
}

