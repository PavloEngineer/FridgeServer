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
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
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


    @PostMapping("/account/{userName}/update")
    public void updateUserAccount(@PathVariable String userName, @RequestParam("file") MultipartFile file) {
        userService.saveUser(userService.findUserByEmail(userName), file);
    }

    @GetMapping("/account/{userName}")
    public ResponseEntity<User> getPresentUser(@PathVariable String userName) {
        return ResponseEntity.ok(userService.findUserByEmail(userName));
    }

    @GetMapping("/photo/{userName}")
    public byte[]  getUserPhoto(@PathVariable String userName) {
        return userService.getUserPhoto(userName);
    }

    @PostMapping("/account/delete")
    public void deleteUser() {
        userService.deleteUser((Integer) session.getAttribute(Constants.USER_ID));
    }

    @GetMapping("/history/orders")
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
