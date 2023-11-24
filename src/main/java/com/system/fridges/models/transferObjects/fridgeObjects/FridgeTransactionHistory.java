package com.system.fridges.models.transferObjects.fridgeObjects;

import java.time.LocalDateTime;

public class FridgeTransactionHistory {

    public LocalDateTime end_date;

    public String name;
    public String surname;
    public String patronymic;

    public String email;

    public FridgeTransactionHistory(LocalDateTime endDate, String userName, String userSurname, String userPatronymic, String userEmail) {
        this.end_date = endDate;
        this.name = userName;
        this.surname = userSurname;
        this.patronymic = userPatronymic;
        this.email = userEmail;
    }

}
