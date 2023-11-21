package com.system.fridges.models.transferObjects;

public class FridgeSpending{
    public int fridgeId;
    public String modelName;
    public Double energyPerYear;
    public Double spendingMoney;

    public FridgeSpending(int fridgeId, String modelName, Double energyPerYear, Double spendingMoney) {
        this.fridgeId = fridgeId;
        this.modelName = modelName;
        this.energyPerYear = energyPerYear;
        this.spendingMoney = spendingMoney;
    }
}
