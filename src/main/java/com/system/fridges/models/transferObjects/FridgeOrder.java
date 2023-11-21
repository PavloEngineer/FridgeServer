package com.system.fridges.models.transferObjects;

import java.util.Date;

public class FridgeOrder {

    public Date dateDelivery;
    public String userName;
    public String userSurname;
    public String userPatronymic;
    public String userEmail;

    public FridgeOrder(Date dateDelivery, String userName, String userSurname, String userPatronymic, String userEmail) {
        this.dateDelivery = dateDelivery;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPatronymic = userPatronymic;
        this.userEmail = userEmail;
    }
}
