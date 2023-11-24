package com.system.fridges.models.transferObjects.foodObjects;

import java.time.LocalDateTime;
import java.util.Date;

public class FoodInFridge {

    public String name;

    public int number_boxes;

    public Date date_validity;

    public LocalDateTime end_date;

    public String user_name;

    public String surname;

    public String patronymic;

    public String email;

    public FoodInFridge(String foodName, int numberBoxes, Date dateValidity, LocalDateTime transactionEndDate,
                          String name, String userSurname, String userPatronymic, String userEmail) {
        this.name = foodName;
        this.number_boxes = numberBoxes;
        this.date_validity = dateValidity;
        this.end_date = transactionEndDate;
        this.user_name = name;
        this.surname = userSurname;
        this.patronymic = userPatronymic;
        this.email = userEmail;
    }
}
