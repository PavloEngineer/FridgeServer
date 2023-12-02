package com.system.fridges.controllers;

import com.system.fridges.models.AutoOrder;
import com.system.fridges.models.Food;
import com.system.fridges.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserController userController;

    @Test
    void addOrdersReturnsValidResponse() {
        // Arrange
        List<AutoOrder> orders = new ArrayList<>();

        // Act
        userController.addOrders(orders);

        // Assert
        verify(userService, times(1)).addAutoOrders(orders);
    }

    @Test
    void addFoodReturnsValidResponse() {
        // Arrange
        List<Food> food = new ArrayList<>();

        // Act
        userController.addFood(food);

        // Assert
        verify(userService, times(1)).addFood(food);
    }
}
