package com.system.fridges.models.transferObjects.fridgeObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FridgeSpending{

    @JsonProperty("fridge_id")
    private int fridge_id;

    @JsonProperty("name_model")
    private String name_model;

    @JsonProperty("energy_per_year")
    private Double energy_per_year;

    @JsonProperty("spendingMoney")
    private Double spendingMoney;
}
