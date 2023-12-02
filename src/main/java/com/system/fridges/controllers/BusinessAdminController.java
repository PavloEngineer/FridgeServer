package com.system.fridges.controllers;


import com.system.fridges.models.*;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeSpending;
import com.system.fridges.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/businessAdmin")
public class BusinessAdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/electricity")
    public ResponseEntity<List<FridgeSpending>> getSpendingElectricity(float price, String nameCompany) {
        return ResponseEntity.ok(adminService.getSpendingElectricity(price, nameCompany));
    }

    @GetMapping("/electricitySum")
    public ResponseEntity<Float> getSumSpending(float price, String nameCompany) {
        return ResponseEntity.ok(adminService.getSumSpending(price, nameCompany));
    }

    @GetMapping("/allFridges")
    public ResponseEntity<List<Fridge>> getAllFridges() {
        return ResponseEntity.ok(adminService.getAllFridges());
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/allAccess")
    public ResponseEntity<List<Access>> getAllAccess() {
        return ResponseEntity.ok(adminService.getAllAccess());
    }

    @GetMapping("/allOffice")
    public ResponseEntity<List<Office>> getAllOffice() {
        return ResponseEntity.ok(adminService.getAllOffice());
    }

    @GetMapping("/allModel")
    public ResponseEntity<List<Model>> getAllModel() {
        return ResponseEntity.ok(adminService.getAllModel());
    }

    @GetMapping("/allSubscription")
    public ResponseEntity<List<Subscription>> getAllSubscription() {
        return ResponseEntity.ok(adminService.getAllSubscription());
    }

    @GetMapping("/allAutoOrder")
    public ResponseEntity<List<AutoOrder>> getAllOrder() {
        return ResponseEntity.ok(adminService.getAllOrder());
    }

    @GetMapping("/allProduct")
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(adminService.getAllProduct());
    }

    @GetMapping("/allFood")
    public ResponseEntity<List<Food>> getAllFood() {
        return ResponseEntity.ok(adminService.getAllFood());
    }

    @GetMapping("/allTransaction")
    public ResponseEntity<List<Transaction>> getAllTransaction() {
        return ResponseEntity.ok(adminService.getAllTransaction());
    }
}
