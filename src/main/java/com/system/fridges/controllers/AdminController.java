package com.system.fridges.controllers;


import com.system.fridges.models.*;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeSpending;
import com.system.fridges.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

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
}
