package com.system.fridges.models.transferObjects;

import java.time.LocalDateTime;
import java.util.Date;

public class FoodInFridge {

    public String foodName;
    public int numberBoxes;
    public Date dateValidity;
    public LocalDateTime transactionEndDate;
    public String userName;
    public String userSurname;
    public String userPatronymic;
    public String userEmail;

    public FoodInFridge(String foodName, int numberBoxes, Date dateValidity, LocalDateTime transactionEndDate,
                          String userName, String userSurname, String userPatronymic, String userEmail) {
        this.foodName = foodName;
        this.numberBoxes = numberBoxes;
        this.dateValidity = dateValidity;
        this.transactionEndDate = transactionEndDate;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPatronymic = userPatronymic;
        this.userEmail = userEmail;
    }
}
