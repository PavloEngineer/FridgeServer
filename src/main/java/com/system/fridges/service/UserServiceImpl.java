package com.system.fridges.service;

import com.system.fridges.models.Fridge;
import com.system.fridges.models.Subscription;
import com.system.fridges.models.Transaction;
import com.system.fridges.models.User;
import com.system.fridges.models.transferObjects.userObjects.UserTransactionHistory;
import com.system.fridges.models.transferObjects.userObjects.UserFood;
import com.system.fridges.models.transferObjects.userObjects.UserOrder;
import com.system.fridges.repositories.*;
import com.system.fridges.security.PasswordHashing;
import com.system.fridges.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

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

    @Value("${upload.path}")
    private String uploadPath;

    public UserServiceImpl() {
    }

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

    public byte[] getUserPhoto(int userId) {
        String photoPath = userRepository.findById(userId).get().getPhoto();
        if (photoPath != null) {
            try {
                Path path = Paths.get(photoPath);
                return Files.readAllBytes(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void saveUser(User user, MultipartFile file) {
        PasswordHashing passwordHashing = new PasswordHashing();
        user.setHashPassword(passwordHashing.encodePassword(user.getHashPassword()));
        user.setPhoto(getPathAndSavePhoto(file));
        userRepository.save(user);
    }

    private String getPathAndSavePhoto(MultipartFile file) {
        if (file == null) return null;
        try {
            // Отримати шлях до теки проекту

            String folderPath = System.getProperty(uploadPath);

            // Створити файл у папці "img"
            File destination = new File(folderPath, Objects.requireNonNull(file.getOriginalFilename()));

            // Зберегти файл на сервері
            FileCopyUtils.copy(file.getBytes(), destination);

            // Повернути шлях до збереженого файлу
            return destination.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return "Upload failed";
        }
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public boolean hasActualSubscription(int userId) {
        return subscriptionRepository.getActualSubscriptionsForUser(userId).isEmpty();
    }

    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
