package com.system.fridges.models.transferObjects.fridgeObjects;

public class FridgeSpending{
    public int fridge_id;
    public String name_model;
    public Double energy_per_year;
    public Double spendingMoney;

    public FridgeSpending(int fridgeId, String modelName, Double energyPerYear, Double spendingMoney) {
        this.fridge_id = fridgeId;
        this.name_model = modelName;
        this.energy_per_year = energyPerYear;
        this.spendingMoney = spendingMoney;
    }
}
