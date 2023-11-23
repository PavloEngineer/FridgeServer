package com.system.fridges.models.transferObjects;

import java.time.LocalDateTime;
import java.util.Date;

public class UserOrder {

    public LocalDateTime dateDelivery;
    public String orderNumber;
    public int fridgeAccess;
    public String productName;
    public double productWeight;

    public UserOrder(LocalDateTime dateDelivery, String orderNumber, int fridgeAccess, String productName, double productWeight) {
        this.dateDelivery = dateDelivery;
        this.orderNumber = orderNumber;
        this.fridgeAccess = fridgeAccess;
        this.productName = productName;
        this.productWeight = productWeight;
    }
}
