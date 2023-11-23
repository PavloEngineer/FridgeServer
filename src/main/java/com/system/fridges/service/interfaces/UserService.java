package com.system.fridges.service.interfaces;

import com.system.fridges.models.Fridge;
import com.system.fridges.models.User;
import com.system.fridges.models.transferObjects.SpoiledFood;
import com.system.fridges.models.transferObjects.UserTransactionHistory;
import com.system.fridges.models.transferObjects.UserFood;
import com.system.fridges.models.transferObjects.UserOrder;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(int userId);

    void saveUser(User user);

    void deleteUser(int userId);

    List<Fridge> getFridgesByUserId(int userId);

    List<UserFood> getAllFoodUserById(int userId);

    List<UserTransactionHistory> getTransactionHistoryByUserId(int userId);

    List<UserOrder> getAllOrdersForUserById(int userId);
}
