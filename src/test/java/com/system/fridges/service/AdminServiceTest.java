package com.system.fridges.service;


import com.system.fridges.models.*;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeSpending;
import com.system.fridges.repositories.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    private FridgeRepository fridgeRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private FoodRepository foodRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AutoOrderRepository autoOrderRepository;

    @Mock
    private SubscriptionRepository subscriptionRepository;

    @Mock
    private OfficeRepository officeRepository;

    @Mock
    private ModelRepository modelRepository;

    @Mock
    private AccessRepository accessRepository;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void doBackupDatabaseTest() {
        String backupPath = "E:\\Projects\\fridges\\database\\backup.sql";
        byte[] backupPathHash = Base64.getEncoder().encode(backupPath.getBytes());
        boolean result = adminService.doBackupDatabase(backupPathHash);
        assertTrue(result);
    }

    @Test
    public void restoreDatabaseTest() {
        String backupPath = "E:\\Projects\\fridges\\database\\backup.sql";
        byte[] backupPathHash = Base64.getEncoder().encode(backupPath.getBytes());
        boolean result = adminService.restoreDatabase(backupPathHash);
        assertTrue(result);
    }

    @Test
    public void getSpendingElectricityReturnsStatistic() {
        // Arrange
        int price = 100;
        String nameCompany = "Epam";
        List<FridgeSpending> expectedSpendingList = List.of(new FridgeSpending(1, "Epam", 23000.0, 10.0));
        when(fridgeRepository.spendingMoneyForEveryFridge(price, nameCompany)).thenReturn(expectedSpendingList);

        // Act
        List<FridgeSpending> result = adminService.getSpendingElectricity(price, nameCompany);

        // Assert
        assertEquals(expectedSpendingList, result);
    }

    @Test
    public void getSumSpendingReturnsSum() {
        // Arrange
        float price = 100.0f;
        String nameCompany = "ExampleCompany";
        float expectedSumSpending = 500.0f;
        when(fridgeRepository.spendingMoneyAllFridges(price, nameCompany)).thenReturn(expectedSumSpending);

        // Act
        float result = adminService.getSumSpending(price, nameCompany);

        // Assert
        assertEquals(expectedSumSpending, result, 0.01);
    }

    @Test
    public void getAllFridgesReturnsFridges() {
        // Arrange
        List<Fridge> expectedFridges = Arrays.asList(new Fridge(), new Fridge());
        when(fridgeRepository.findAll()).thenReturn(expectedFridges);

        // Act
        List<Fridge> result = adminService.getAllFridges();

        // Assert
        assertEquals(expectedFridges, result);
    }

    @Test
    void getAllUsersReturnsUsers() {
        // Arrange
        List<User> expectedUsers = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(expectedUsers);

        // Act
        List<User> result = adminService.getAllUsers();

        // Assert
        assertEquals(expectedUsers, result);
    }

    @Test
    void getAllAccessReturnsAccess() {
        // Arrange
        List<Access> expectedAccess = Arrays.asList(new Access(), new Access());
        when(accessRepository.findAll()).thenReturn(expectedAccess);

        // Act
        List<Access> result = adminService.getAllAccess();

        // Assert
        assertEquals(expectedAccess, result);
    }

    @Test
    void getAllOfficeReturnsOffice() {
        // Arrange
        List<Office> expectedAccess = Arrays.asList(new Office(), new Office());
        when(officeRepository.findAll()).thenReturn(expectedAccess);

        // Act
        List<Office> result = adminService.getAllOffice();

        // Assert
        assertEquals(expectedAccess, result);
    }

    @Test
    void getAllModelReturnsModel() {
        // Arrange
        List<Model> expectedAccess = Arrays.asList(new Model(), new Model());
        when(modelRepository.findAll()).thenReturn(expectedAccess);

        // Act
        List<Model> result = adminService.getAllModel();

        // Assert
        assertEquals(expectedAccess, result);
    }

    @Test
    void getAllSubscriptionReturnsSubscription() {
        // Arrange
        List<Subscription> expectedAccess = Arrays.asList(new Subscription(), new Subscription());
        when(subscriptionRepository.findAll()).thenReturn(expectedAccess);

        // Act
        List<Subscription> result = adminService.getAllSubscription();

        // Assert
        assertEquals(expectedAccess, result);
    }

    @Test
    void getAllOrderReturnsOrder() {
        // Arrange
        List<AutoOrder> expectedAccess = Arrays.asList(new AutoOrder(), new AutoOrder());
        when(autoOrderRepository.findAll()).thenReturn(expectedAccess);

        // Act
        List<AutoOrder> result = adminService.getAllOrder();

        // Assert
        assertEquals(expectedAccess, result);
    }

    @Test
    void getAllOrderReturnsProduct() {
        // Arrange
        List<Product> expectedAccess = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(expectedAccess);

        // Act
        List<Product> result = adminService.getAllProduct();

        // Assert
        assertEquals(expectedAccess, result);
    }

    @Test
    void getAllFoodReturnsFood() {
        // Arrange
        List<Food> expectedAccess = Arrays.asList(new Food(), new Food());
        when(foodRepository.findAll()).thenReturn(expectedAccess);

        // Act
        List<Food> result = adminService.getAllFood();

        // Assert
        assertEquals(expectedAccess, result);
    }

    @Test
    void getAllTransactionReturnsTransaction() {
        // Arrange
        List<Transaction> expectedAccess = Arrays.asList(new Transaction(), new Transaction());
        when(transactionRepository.findAll()).thenReturn(expectedAccess);

        // Act
        List<Transaction> result = adminService.getAllTransaction();

        // Assert
        assertEquals(expectedAccess, result);
    }

    @Test
    public void addFridgesTest() {
        // Arrange
        List<Fridge> fridges = Arrays.asList(new Fridge(), new Fridge());

        // Act
        adminService.addFridges(fridges);

        // Assert
        verify(fridgeRepository, times(1)).saveAll(fridges);
    }

    @Test
    public void addUsersTest() {
        // Arrange
        List<User> users = Arrays.asList(new User(), new User());

        // Act
        adminService.addUser(users);

        // Assert
        verify(userRepository, times(1)).saveAll(users);
    }

    @Test
    public void addAccessTest() {
        // Arrange
        List<Access> accesses = Arrays.asList(new Access(), new Access());

        // Act
        adminService.addAccess(accesses);

        // Assert
        verify(accessRepository, times(1)).saveAll(accesses);
    }

    @Test
    public void addOfficeTest() {
        // Arrange
        List<Office> offices = Arrays.asList(new Office(), new Office());

        // Act
        adminService.addOffice(offices);

        // Assert
        verify(officeRepository, times(1)).saveAll(offices);
    }

    @Test
    public void addModelTest() {
        // Arrange
        List<Model> models = Arrays.asList(new Model(), new Model());

        // Act
        adminService.addModel(models);

        // Assert
        verify(modelRepository, times(1)).saveAll(models);
    }

    @Test
    public void addSubscriptionTest() {
        // Arrange
        List<Subscription> subscriptions = Arrays.asList(new Subscription(), new Subscription());

        // Act
        adminService.addSubscription(subscriptions);

        // Assert
        verify(subscriptionRepository, times(1)).saveAll(subscriptions);
    }

    @Test
    public void addProductTest() {
        // Arrange
        List<Product> products = Arrays.asList(new Product(), new Product());

        // Act
        adminService.addProduct(products);

        // Assert
        verify(productRepository, times(1)).saveAll(products);
    }

    @Test
    public void addAutoOrderTest() {
        // Arrange
        List<AutoOrder> autoOrders = Arrays.asList(new AutoOrder(), new AutoOrder());

        // Act
        adminService.addAutoOrder(autoOrders);

        // Assert
        verify(autoOrderRepository, times(1)).saveAll(autoOrders);
    }

    @Test
    public void addFoodTest() {
        // Arrange
        List<Food> foods = Arrays.asList(new Food(), new Food());

        // Act
        adminService.addFood(foods);

        // Assert
        verify(foodRepository, times(1)).saveAll(foods);
    }

    @Test
    public void addTransactionTest() {
        // Arrange
        List<Transaction> transactions = Arrays.asList(new Transaction(), new Transaction());

        // Act
        adminService.addTransaction(transactions);

        // Assert
        verify(transactionRepository, times(1)).saveAll(transactions);
    }

    @Test
    public void deleteUserTest() {
        // Arrange
        List<Integer> userIds = Arrays.asList(1, 2, 3);

        // Act
        adminService.deleteUser(userIds);

        // Assert
        verify(userRepository, times(1)).deleteAllById(userIds);
    }

    @Test
    public void deleteFridgeTest() {
        // Arrange
        List<Integer> fridgeIds = Arrays.asList(1, 2, 3);

        // Act
        adminService.deleteFridge(fridgeIds);

        // Assert
        verify(fridgeRepository, times(1)).deleteAllById(fridgeIds);
    }

    @Test
    public void deleteAccessTest() {
        // Arrange
        List<Integer> accessIds = Arrays.asList(1, 2, 3);

        // Act
        adminService.deleteAccess(accessIds);

        // Assert
        verify(accessRepository, times(1)).deleteAllById(accessIds);
    }

    @Test
    public void deleteOfficeTest() {
        // Arrange
        List<Integer> officeIds = Arrays.asList(1, 2, 3);

        // Act
        adminService.deleteOffice(officeIds);

        // Assert
        verify(officeRepository, times(1)).deleteAllById(officeIds);
    }

    @Test
    public void deleteModelTest() {
        // Arrange
        List<Integer> modelIds = Arrays.asList(1, 2, 3);

        // Act
        adminService.deleteModel(modelIds);

        // Assert
        verify(modelRepository, times(1)).deleteAllById(modelIds);
    }

    @Test
    public void deleteSubscriptionTest() {
        // Arrange
        List<Integer> subscriptionIds = Arrays.asList(1, 2, 3);

        // Act
        adminService.deleteSubscription(subscriptionIds);

        // Assert
        verify(subscriptionRepository, times(1)).deleteAllById(subscriptionIds);
    }

    @Test
    public void deleteProductTest() {
        // Arrange
        List<Integer> productIds = Arrays.asList(1, 2, 3);

        // Act
        adminService.deleteProduct(productIds);

        // Assert
        verify(productRepository, times(1)).deleteAllById(productIds);
    }

    @Test
    public void deleteAutoOrderTest() {
        // Arrange
        List<Integer> autoOrderIds = Arrays.asList(1, 2, 3);

        // Act
        adminService.deleteAutoOrder(autoOrderIds);

        // Assert
        verify(autoOrderRepository, times(1)).deleteAllById(autoOrderIds);
    }

    @Test
    public void deleteFoodTest() {
        // Arrange
        List<Integer> foodIds = Arrays.asList(1, 2, 3);

        // Act
        adminService.deleteFood(foodIds);

        // Assert
        verify(foodRepository, times(1)).deleteAllById(foodIds);
    }

    @Test
    public void deleteTransactionTest() {
        // Arrange
        List<Integer> transactionIds = Arrays.asList(1, 2, 3);

        // Act
        adminService.deleteTransaction(transactionIds);

        // Assert
        verify(transactionRepository, times(1)).deleteAllById(transactionIds);
    }
}
