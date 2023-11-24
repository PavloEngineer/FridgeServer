package com.system.fridges.controllers;

import com.system.fridges.models.Fridge;
import com.system.fridges.models.Transaction;
import com.system.fridges.models.User;
import com.system.fridges.models.transferObjects.userObjects.UserFood;
import com.system.fridges.models.transferObjects.userObjects.UserOrder;
import com.system.fridges.models.transferObjects.userObjects.UserTransactionHistory;
import com.system.fridges.service.UserServiceImpl;
import com.system.fridges.service.utils.Constants;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/account/update")
    public void updateUserAccount(@RequestBody User user, @RequestParam("file") MultipartFile file) {
        userService.saveUser(user, file);
    }

    @GetMapping("/account")
    public User getPresentUser() {
        return userService.getUserById((Integer) session.getAttribute(Constants.USER_ID));
    }

    @GetMapping("/photo")
    public byte[]  getUserPhoto() {
        return userService.getUserPhoto((Integer) session.getAttribute(Constants.USER_ID));
    }

    @PostMapping("/account/delete")
    public void deleteUser() {
        userService.deleteUser((Integer) session.getAttribute(Constants.USER_ID));
    }

    @GetMapping("/historyUsing")
    public List<UserOrder> getAllOrders() {
        return userService.getAllOrdersForUserById((Integer) session.getAttribute(Constants.USER_ID));
    }

    @GetMapping("/historyUsing")
    public List<UserTransactionHistory> getHistoryUsing() {
        return userService.getTransactionHistoryByUserId((Integer) session.getAttribute(Constants.USER_ID));
    }

    @GetMapping("/food")
    public List<UserFood> getUserFood() {
        return userService.getAllFoodUserById((Integer) session.getAttribute(Constants.USER_ID));
    }

    @GetMapping("/fridges")
    public List<Fridge> getAvailableFridges() {
        return userService.getFridgesByUserId((Integer) session.getAttribute(Constants.USER_ID));
    }

    @GetMapping("/subscription")
    public boolean hasActualSubscription() {
        return userService.hasActualSubscription((Integer) session.getAttribute(Constants.USER_ID));
    }

    @PostMapping("/addTransaction")
    public void addTransaction(@RequestBody Transaction transaction) {
        userService.addTransaction(transaction);
    }

    @GetMapping("/exit")
    public boolean isSessionClosed() {
        session.invalidate();
        return true;
    }
}
