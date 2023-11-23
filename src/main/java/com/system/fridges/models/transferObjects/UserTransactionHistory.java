package com.system.fridges.models.transferObjects;

import java.time.LocalDateTime;

public class UserTransactionHistory {

    public LocalDateTime endDate;
    public int fridgeAccess;

    public UserTransactionHistory(LocalDateTime endDate, int fridgeAccess) {
        this.endDate = endDate;
        this.fridgeAccess = fridgeAccess;
    }
}
