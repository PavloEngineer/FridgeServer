package com.system.fridges.service.utils;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DatabaseManagerFunctionalTest {

    private DatabaseManager databaseManager = new DatabaseManager();

    private final String backupPath = "E:\\Projects\\fridges\\database\\backup.sql";

    @Test
    public void backupAndRestoreTest() {
        // Arrange
        boolean backupResult = databaseManager.backupSuccessful(backupPath);

        // Assert
        assertTrue(backupResult);
    }

    @Test
    public void restoreSuccessfulTest() {
        // Arrange (можете додати модифікації бази даних перед відновленням)
        boolean restoreResult = databaseManager.restoreSuccessful(backupPath);

        // Assert
        assertTrue(restoreResult);
    }
}
