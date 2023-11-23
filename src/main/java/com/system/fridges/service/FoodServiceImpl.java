package com.system.fridges.service;

import com.system.fridges.models.Fridge;
import com.system.fridges.models.transferObjects.UserFood;
import com.system.fridges.repositories.FoodRepository;
import org.hibernate.sql.exec.ExecutionException;

import java.util.List;

public class FoodServiceImpl {

    private FoodRepository foodRepository;
    public List<UserFood> getAllFoodUserById(int userId) {
        if (userId >= 0) {
             return foodRepository.getAllFoodUserById(userId);
        } else {
            throw new IllegalArgumentException("Incorrect user ID");
        }
    }

}
