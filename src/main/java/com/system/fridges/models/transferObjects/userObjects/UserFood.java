package com.system.fridges.models.transferObjects.userObjects;

import java.time.LocalDateTime;
import java.util.Date;

public class UserFood {

    public String name;
    public int number_boxes;
    public Date date_validity;

    public LocalDateTime end_date;
    public int fridge_access;

    public UserFood(String foodName, int numberBoxes, Date dateValidity, LocalDateTime transactionEndDate, int fridgeAccess) {
        this.name = foodName;
        this.number_boxes = numberBoxes;
        this.date_validity = dateValidity;
        this.end_date = transactionEndDate;
        this.fridge_access = fridgeAccess;
    }
}
