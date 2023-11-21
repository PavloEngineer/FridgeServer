package com.system.fridges.models.transferObjects;

import java.util.Date;

public class UserOrder {

    public Date dateDelivery;
    public String orderNumber;
    public int fridgeAccess;
    public String productName;
    public double productWeight;

    public UserOrder(Date dateDelivery, String orderNumber, int fridgeAccess, String productName, double productWeight) {
        this.dateDelivery = dateDelivery;
        this.orderNumber = orderNumber;
        this.fridgeAccess = fridgeAccess;
        this.productName = productName;
        this.productWeight = productWeight;
    }
}
