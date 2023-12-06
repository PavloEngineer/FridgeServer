package com.system.fridges.service;

import com.system.fridges.models.*;
import com.system.fridges.models.transferObjects.JwtAuthenticationResponse;
import com.system.fridges.models.transferObjects.userObjects.SignInRequest;
import com.system.fridges.models.transferObjects.userObjects.UserTransactionHistory;
import com.system.fridges.models.transferObjects.userObjects.UserFood;
import com.system.fridges.models.transferObjects.userObjects.UserOrder;
import com.system.fridges.repositories.*;
import com.system.fridges.security.PasswordHashing;
import com.system.fridges.service.interfaces.UserService;
import com.system.fridges.service.utils.PhotoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationServiceImpl authenticationService;


    private String uploadPath = "/fridges/img";

    public UserServiceImpl() {}

    public  UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findUserByEmail(username).orElse(null);
                if (user == null) {
                    throw new UsernameNotFoundException("User not found with username: " + username);
                }
                return new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getHashPassword(),
                        // Тут ви можете вказати ролі користувача. Наприклад, якщо у вас є поле roles у класі User:
                        // user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                        // Де roles - це колекція ролей користувача.
                        Collections.emptyList()
                );
            }
        };
    }

    // TODO: incorrect place
    public JwtAuthenticationResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getEmail(),
                signInRequest.getPassword())
        );

        var user = userDetailsService().loadUserByUsername(signInRequest.getEmail());
        var jwt = authenticationService.generationToken(user);
        var refreshToken = authenticationService.generationRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }

    @Override
    public List<Fridge> getFridgesByUserEmail(String email) {
        User user = userRepository.findUserByEmail(email).orElse(new User());
        return fridgeRepository.getFridgesByUserId(user.getUserId());
    }

    @Override
    public List<UserFood> getAllFoodUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email).orElse(new User());
        return foodRepository.getAllFoodUserById(user.getUserId());
    }

    @Override
    public List<UserTransactionHistory> getTransactionHistoryByEmail(String email) {
        User user = userRepository.findUserByEmail(email).orElse(new User());
        return transactionRepository.getHistoryUsingByUserId(user.getUserId());
    }

    @Override
    public List<UserOrder> getAllOrdersForUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email).orElse(new User());
        List<Subscription> presentSubscription = subscriptionRepository.getActualSubscriptionsForUser(user.getUserId());
        if (!presentSubscription.isEmpty()) {
            return autoOrderRepository.getAllOrdersForUserById(user.getUserId());
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public byte[] getUserPhoto(String email) {
        String photoPath = userRepository.findUserByEmail(email).orElse(new User()).getPhoto();
        return PhotoManager.pushPhoto(photoPath);
    }

    @Override
    public void saveUser(User user, MultipartFile file) {
        PasswordHashing passwordHashing = new PasswordHashing();
        user.setHashPassword(passwordHashing.encodePassword(user.getHashPassword()));
        PhotoManager photoManager = new PhotoManager(file);
        photoManager.savePhoto();
        user.setPhoto(photoManager.getAbsolutePath());
        userRepository.save(user);
    }

//    private void savePhoto(MultipartFile file) {
//        if (file == null || file.isEmpty() || file.getOriginalFilename() == null) return "";
//        try {
//            // Отримати шлях до теки проекту
//            String folderPath = System.getProperty(uploadPath);
//
//            // Створити файл у папці "img"
//            File destination = new File(folderPath, Objects.requireNonNull(file.getOriginalFilename()));
//
//            // Зберегти файл на сервері
//            FileCopyUtils.copy(file.getBytes(), destination);
//
//            // Повернути шлях до збереженого файлу
//            return destination.getAbsolutePath();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "Upload failed";
//        }
//    }

    @Override
    public void deleteUser(String email) {
        User user = userRepository.findUserByEmail(email).orElse(new User());
        userRepository.deleteById(user.getUserId());
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(new User());
    }

    @Override
    public boolean hasActualSubscription(String email) {
        User user = userRepository.findUserByEmail(email).orElse(new User());
        return !subscriptionRepository.getActualSubscriptionsForUser(user.getUserId()).isEmpty();
    }

    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void addAutoOrders(List<AutoOrder> orders) {
        autoOrderRepository.saveAll(orders);
    }

    public void addFood(List<Food> food) {
        foodRepository.saveAll(food);
    }

    public void addSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }
}
