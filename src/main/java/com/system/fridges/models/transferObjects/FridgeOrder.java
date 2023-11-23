package com.system.fridges.models.transferObjects;

import java.time.LocalDateTime;
import java.util.Date;

public class FridgeOrder {

    public int orderId;

    public LocalDateTime dateDelivery;
    public String userName;
    public String userSurname;
    public String userPatronymic;
    public String userEmail;

    public FridgeOrder(int orderId, LocalDateTime dateDelivery, String userName, String userSurname, String userPatronymic, String userEmail) {
        this.orderId = orderId;
        this.dateDelivery = dateDelivery;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPatronymic = userPatronymic;
        this.userEmail = userEmail;
    }
}
