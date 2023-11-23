package com.system.fridges.service;

import com.system.fridges.models.Fridge;
import com.system.fridges.models.Subscription;
import com.system.fridges.models.User;
import com.system.fridges.models.transferObjects.UserTransactionHistory;
import com.system.fridges.models.transferObjects.UserFood;
import com.system.fridges.models.transferObjects.UserOrder;
import com.system.fridges.repositories.*;
import com.system.fridges.security.PasswordHashing;
import com.system.fridges.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private FridgeRepository fridgeRepository;

    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AutoOrderRepository autoOrderRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public List<Fridge> getFridgesByUserId(int userId) {
        return fridgeRepository.getFridgesByUserId(userId);
    }

    @Override
    public List<UserFood> getAllFoodUserById(int userId) {
        return foodRepository.getAllFoodUserById(userId);
    }

    @Override
    public List<UserTransactionHistory> getTransactionHistoryByUserId(int userId) {transactionRepository.getHistoryUsingByUserId(userId);
        return transactionRepository.getHistoryUsingByUserId(userId);
    }

    @Override
    public List<UserOrder> getAllOrdersForUserById(int userId) {
        List<Subscription> presentSubscription = subscriptionRepository.getActualSubscriptionsForUser(userId);
        if (!presentSubscription.isEmpty()) {
            return autoOrderRepository.getAllOrdersForUserById(userId);
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

//    @Override
//     public void updateUserById(User newUser) {
//         PasswordHashing passwordHashing = new PasswordHashing();
//         newUser.setHashPassword(passwordHashing.encodePassword(newUser.getHashPassword()));
//         userRepository.save(newUser);
//     }

    @Override
    public void saveUser(User user) {
        PasswordHashing passwordHashing = new PasswordHashing();
        user.setHashPassword(passwordHashing.encodePassword(user.getHashPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}
