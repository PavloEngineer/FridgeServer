package com.system.fridges.controllers;


import com.system.fridges.models.*;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeSpending;
import com.system.fridges.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/electricity")
    public List<FridgeSpending> getSpendingElectricity(float price, String nameCompany) {
        return adminService.getSpendingElectricity(price, nameCompany);
    }

    @GetMapping("/electricity")
    public float getSumSpending(float price, String nameCompany) {
        return adminService.getSumSpending(price, nameCompany);
    }

    @GetMapping("/allFridges")
    public List<Fridge> getAllFridges() {
        return adminService.getAllFridges();
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/allAccess")
    public List<Access> getAllAccess() {
        return adminService.getAllAccess();
    }

    @GetMapping("/allOffice")
    public List<Office> getAllOffice() {
        return adminService.getAllOffice();
    }

    @GetMapping("/allModel")
    public List<Model> getAllModel() {
        return adminService.getAllModel();
    }

    @GetMapping("/allSubscription")
    public List<Subscription> getAllSubscription() {
        return adminService.getAllSubscription();
    }

    @GetMapping("/allAutoOrder")
    public List<AutoOrder> getAllOrder() {
        return adminService.getAllOrder();
    }

    @GetMapping("/allProduct")
    public List<Product> getAllProduct() {
        return adminService.getAllProduct();
    }

    @GetMapping("/allFood")
    public List<Food> getAllFood() {
        return adminService.getAllFood();
    }

    @GetMapping("/transaction")
    public List<Transaction> getAllTransaction() {
        return adminService.getAllTransaction();
    }

    @PostMapping("/addFridges")
    public void addFridges(@RequestBody List<Fridge> fridges) {
        adminService.addFridges(fridges);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody List<User> user) {
        adminService.addUser(user);
    }

    @PostMapping("/addAccess")
    public void addAccess(@RequestBody List<Access> access) {
        adminService.addAccess(access);
    }

    @PostMapping("/addOffice")
    public void addOffice(@RequestBody List<Office> office) {
        adminService.addOffice(office);
    }

    @PostMapping("/addModel")
    public void addModel(@RequestBody List<Model> model) {
        adminService.addModel(model);
    }

    @PostMapping("/addSubscription")
    public void addSubscription(@RequestBody List<Subscription> subscription) {
        adminService.addSubscription(subscription);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody List<Product> product) {
        adminService.addProduct(product);
    }

    @PostMapping("/addAutoOrder")
    public void addAutoOrder(@RequestBody List<AutoOrder> autoOrders) {
        adminService.addAutoOrder(autoOrders);
    }

    @PostMapping("/addFood")
    public void addFood(@RequestBody List<Food> food) {
        adminService.addFood(food);
    }

    @PostMapping("/addTransaction")
    public void addTransaction(@RequestBody List<Transaction> transaction) {
        adminService.addTransaction(transaction);
    }

    @PostMapping("/deleteUser")
    public void deleteUser(@RequestBody List<Integer> user) {
        adminService.deleteUser(user);
    }

    @PostMapping("/deleteFridge")
    public void deleteFridge(@RequestBody List<Integer> fridge) {
        adminService.deleteFridge(fridge);
    }

    @PostMapping("/deleteAccess")
    public void deleteAccess(@RequestBody List<Integer> access) {
        adminService.deleteAccess(access);
    }

    @PostMapping("/deleteOffice")
    public void deleteOffice(@RequestBody List<Integer> office) {
        adminService.deleteOffice(office);
    }

    @PostMapping("/deleteModel")
    public void deleteModel(@RequestBody List<Integer> model) {
        adminService.deleteModel(model);
    }

    @PostMapping("/deleteSubscription")
    public void deleteSubscription(@RequestBody List<Integer> subscription) {
        adminService.deleteSubscription(subscription);
    }

    @PostMapping("/deleteProduct")
    public void deleteProduct(@RequestBody List<Integer> product) {
        adminService.deleteProduct(product);
    }

    @PostMapping("/deleteAutoOrder")
    public void deleteAutoOrder(@RequestBody List<Integer> autoOrder) {
        adminService.deleteAutoOrder(autoOrder);
    }

    @PostMapping("/deleteFood")
    public void deleteFood(@RequestBody List<Integer> food) {
        adminService.deleteFood(food);
    }

    @PostMapping("/deleteTransaction")
    public void deleteTransaction(@RequestBody List<Integer> transaction) {
        adminService.deleteTransaction(transaction);
    }
}
