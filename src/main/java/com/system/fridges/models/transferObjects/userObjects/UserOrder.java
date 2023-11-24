package com.system.fridges.models.transferObjects.userObjects;

import java.time.LocalDateTime;

public class UserOrder {

    public LocalDateTime date_delivery;
    public String number;
    public int fridge_access;

    public String name;
    public double weight;

    public UserOrder(LocalDateTime dateDelivery, String orderNumber, int fridgeAccess, String productName, double productWeight) {
        this.date_delivery = dateDelivery;
        this.number = orderNumber;
        this.fridge_access = fridgeAccess;
        this.name = productName;
        this.weight = productWeight;
    }
}
