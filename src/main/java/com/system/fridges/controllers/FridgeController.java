package com.system.fridges.controllers;


import com.system.fridges.models.AutoOrder;
import com.system.fridges.models.Food;
import com.system.fridges.models.transferObjects.foodObjects.FoodInFridge;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeOrder;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeTransactionHistory;
import com.system.fridges.service.FridgeServiceImpl;
import com.system.fridges.service.utils.Constants;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("*/fridge")
public class FridgeController {

    @Autowired
    private FridgeServiceImpl fridgeService;

    @Autowired
    private HttpSession session;

    @GetMapping("/foodInside")
    public List<FoodInFridge> getAllFood(int fridgeId) {
        return fridgeService.getFoodInFridgeById(fridgeId);
    }

    @GetMapping("/autoOrdering")
    public List<FridgeOrder> getAutoOrdering(int fridgeId) {
        return fridgeService.getAutoOrdersById(fridgeId, (Integer) session.getAttribute(Constants.USER_ID));
    }

    @GetMapping("/transactions")
    public List<FridgeTransactionHistory> getTransactionHistories(int fridgeId) {
        return fridgeService.getTransactionHistoryById(fridgeId);
    }

    @PostMapping("/inventory")
    public void doInventory(int fridgeId) {
        fridgeService.doInventoryForFridge(fridgeId);
    }

    @PostMapping("/doAutoOrder")
    public void doAutoOrder(int fridgeId) {
        fridgeService.doAutoOrdering(fridgeId);
    }

    @PostMapping("/autoOrdering/addOrder")
    public void addOrders(@RequestBody List<AutoOrder> orders) {
        fridgeService.addAutoOrders(orders);
    }

    @PostMapping("/addFood")
    public void addFood(@RequestBody List<Food> food) {
        fridgeService.addFood(food);
    }
}
