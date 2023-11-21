package com.system.fridges.models.transferObjects;

import java.util.Date;

public class UserFood {
    public String foodName;
    public int numberBoxes;
    public Date dateValidity;
    public Date transactionEndDate;
    public int fridgeAccess;

    public UserFood(String foodName, int numberBoxes, Date dateValidity, Date transactionEndDate, int fridgeAccess) {
        this.foodName = foodName;
        this.numberBoxes = numberBoxes;
        this.dateValidity = dateValidity;
        this.transactionEndDate = transactionEndDate;
        this.fridgeAccess = fridgeAccess;
    }
}
