package com.system.fridges.service.interfaces;

import com.system.fridges.models.AutoOrder;
import com.system.fridges.models.Fridge;
import com.system.fridges.models.transferObjects.foodObjects.FoodInFridge;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeOrder;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeSpending;
import com.system.fridges.models.transferObjects.fridgeObjects.FridgeTransactionHistory;

import java.util.List;

public interface FridgeService {

    List<Fridge> getFridgesByUserId(int userId);
    Fridge getFridgeById(int fridgeId);

    void saveFridge(Fridge fridge);

    void deleteFridgeById(int fridgeId);

    List<FridgeSpending> getSpendingStatisticByCompany(float priceForElectricity, String nameCompany);

    float calculateSpendingFridgesByCompany(float priceForElectricity, String nameCompany);

    List<FoodInFridge> getFoodInFridgeById(int fridgeId);

    List<FridgeTransactionHistory> getTransactionHistoryById(int fridgeId);

    List<FridgeOrder> getAutoOrdersById(int fridgeId, String email);

    void doInventoryForFridge(Integer fridgeId);

    void doAutoOrdering(int fridgeId);

//    void doInventoryFridgesInCompany(String nameCompany);
}
