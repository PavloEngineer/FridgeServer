package com.system.fridges.repositories;


import com.system.fridges.models.entities.Fridge;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeSpending;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FridgeRepositoryFunctionalTest {

    @Autowired
    private FridgeRepository fridgeRepository;

    @Test
    @Transactional
    public void spendingMoneyForEveryFridgeTest() {
        // Arrange
        float priceForElectricity = 0.15f;
        String nameCompany = "Epam";

        // Act
        List<FridgeSpending> fridgeSpendingList = fridgeRepository.getSpendingMoneyForEveryFridge(priceForElectricity, nameCompany);

        // Assert
        assertNotNull(fridgeSpendingList);
    }

    @Test
    public void spendingMoneyAllFridgesTest() {
        // Arrange
        float priceForElectricity = 0.15f;
        String nameCompany = "Epam";

        // Act
        float totalSpendingMoney = fridgeRepository.getSpendingMoneyAllFridges(priceForElectricity, nameCompany);

        // Assert
        assertNotNull(totalSpendingMoney);
    }

    @Test
    @Transactional
    public void getFridgesByUserIdTest() {
        // Arrange
        int userId = 1;

        // Act
        List<Fridge> fridges = fridgeRepository.getFridgesByUserId(userId).get();

        // Assert
        assertNotNull(fridges);
    }

    @Test
    @Transactional
    public void getCompanyFridgesTest() {
        // Arrange
        String nameCompany = "Epam";

        // Act
        List<Fridge> companyFridges = fridgeRepository.getCompanyFridges(nameCompany);

        // Assert
        assertNotNull(companyFridges);
    }
}
