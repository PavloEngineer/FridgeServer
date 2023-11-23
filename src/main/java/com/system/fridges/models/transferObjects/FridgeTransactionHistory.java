package com.system.fridges.models.transferObjects;

import java.time.LocalDateTime;

public class FridgeTransactionHistory {
    public LocalDateTime endDate;
    public String userName;
    public String userSurname;
    public String userPatronymic;
    public String userEmail;

    public FridgeTransactionHistory(LocalDateTime endDate, String userName, String userSurname, String userPatronymic, String userEmail) {
        this.endDate = endDate;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPatronymic = userPatronymic;
        this.userEmail = userEmail;
    }

}
