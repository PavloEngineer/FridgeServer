package com.system.fridges.models.transferObjects.foodObjects;

import java.time.LocalDateTime;
import java.util.Date;

public class SpoiledFood {

    public String name;
    public int number_boxes;
    public Date date_validity;

    public LocalDateTime end_date;
    public int user_access;

    public SpoiledFood(String foodName, int numberBoxes, Date dateValidity, LocalDateTime transactionEndDate, int userAccess) {
        this.name = foodName;
        this.number_boxes = numberBoxes;
        this.date_validity = dateValidity;
        this.end_date = transactionEndDate;
        this.user_access = userAccess;
    }
}
