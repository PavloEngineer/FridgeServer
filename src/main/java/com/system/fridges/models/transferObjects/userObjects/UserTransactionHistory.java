package com.system.fridges.models.transferObjects.userObjects;

import java.time.LocalDateTime;

public class UserTransactionHistory {

    public LocalDateTime end_date;
    public int fridge_access;

    public UserTransactionHistory(LocalDateTime endDate, int fridgeAccess) {
        this.end_date = endDate;
        this.fridge_access = fridgeAccess;
    }
}
