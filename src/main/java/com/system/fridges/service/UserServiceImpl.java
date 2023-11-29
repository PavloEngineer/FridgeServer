package com.system.fridges.service;

import com.system.fridges.models.Fridge;
import com.system.fridges.models.Subscription;
import com.system.fridges.models.Transaction;
import com.system.fridges.models.User;
import com.system.fridges.models.transferObjects.JwtAuthenticationResponse;
import com.system.fridges.models.transferObjects.userObjects.SignInRequest;
import com.system.fridges.models.transferObjects.userObjects.UserTransactionHistory;
import com.system.fridges.models.transferObjects.userObjects.UserFood;
import com.system.fridges.models.transferObjects.userObjects.UserOrder;
import com.system.fridges.repositories.*;
import com.system.fridges.security.PasswordHashing;
import com.system.fridges.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
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

    @Value("${upload.path}")
    private String uploadPath;

    public UserServiceImpl() {}

    public  UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findUserByEmail(username);
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
        User user = userRepository.findUserByEmail(email);
        return fridgeRepository.getFridgesByUserId(user.getUserId());
    }

    @Override
    public List<UserFood> getAllFoodUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return foodRepository.getAllFoodUserById(user.getUserId());
    }

    @Override
    public List<UserTransactionHistory> getTransactionHistoryByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return transactionRepository.getHistoryUsingByUserId(user.getUserId());
    }

    @Override
    public List<UserOrder> getAllOrdersForUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
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
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public byte[] getUserPhoto(String email) {
        String photoPath = userRepository.findUserByEmail(email).getPhoto();
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
    public void deleteUser(String email) {
        User user = userRepository.findUserByEmail(email);
        userRepository.deleteById(user.getUserId());
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public boolean hasActualSubscription(String email) {
        User user = userRepository.findUserByEmail(email);
        return !subscriptionRepository.getActualSubscriptionsForUser(user.getUserId()).isEmpty();
    }

    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
