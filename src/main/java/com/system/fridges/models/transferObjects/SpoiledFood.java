package com.system.fridges.models.transferObjects;

import java.time.LocalDateTime;
import java.util.Date;

public class SpoiledFood {

    public String foodName;
    public int numberBoxes;
    public Date dateValidity;
    public LocalDateTime transactionEndDate;
    public int userAccess;

    public SpoiledFood(String foodName, int numberBoxes, Date dateValidity, LocalDateTime transactionEndDate, int userAccess) {
        this.foodName = foodName;
        this.numberBoxes = numberBoxes;
        this.dateValidity = dateValidity;
        this.transactionEndDate = transactionEndDate;
        this.userAccess = userAccess;
    }
}
