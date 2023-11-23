package com.system.fridges.service.interfaces;

import com.system.fridges.models.AutoOrder;
import com.system.fridges.models.Fridge;
import com.system.fridges.models.transferObjects.FoodInFridge;
import com.system.fridges.models.transferObjects.FridgeOrder;
import com.system.fridges.models.transferObjects.FridgeSpending;
import com.system.fridges.models.transferObjects.FridgeTransactionHistory;

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

    List<FridgeOrder> getAutoOrdersById(int fridgeId);

    void doInventoryForFridge(int fridgeId);

    void doAutoOrdering(int fridgeId);

//    void doInventoryFridgesInCompany(String nameCompany);
}
