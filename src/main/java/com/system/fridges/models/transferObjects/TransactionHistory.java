package com.system.fridges.models.transferObjects;

import java.time.LocalDateTime;

public class TransactionHistory {

    public LocalDateTime endDate;
    public int fridgeAccess;

    public TransactionHistory(LocalDateTime endDate, int fridgeAccess) {
        this.endDate = endDate;
        this.fridgeAccess = fridgeAccess;
    }
}
