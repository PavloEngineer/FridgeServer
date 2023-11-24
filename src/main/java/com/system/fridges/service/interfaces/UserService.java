package com.system.fridges.service.interfaces;

import com.system.fridges.models.Fridge;
import com.system.fridges.models.User;
import com.system.fridges.models.transferObjects.userObjects.UserTransactionHistory;
import com.system.fridges.models.transferObjects.userObjects.UserFood;
import com.system.fridges.models.transferObjects.userObjects.UserOrder;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(int userId);

    void saveUser(User user, MultipartFile file);

    void deleteUser(int userId);

    List<Fridge> getFridgesByUserId(int userId);

    List<UserFood> getAllFoodUserById(int userId);

    List<UserTransactionHistory> getTransactionHistoryByUserId(int userId);

    List<UserOrder> getAllOrdersForUserById(int userId);

     User findUserByEmail(String email);

     boolean hasActualSubscription(int userId);
}
