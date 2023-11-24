package com.system.fridges.models.transferObjects.fridgeObjects;

import java.time.LocalDateTime;

public class FridgeOrder {

    public int order_id;

    public LocalDateTime date_delivery;
    public String name;
    public String surname;
    public String patronymic;

    public String email;

    public FridgeOrder(int orderId, LocalDateTime dateDelivery, String userName, String userSurname, String userPatronymic, String userEmail) {
        this.order_id = orderId;
        this.date_delivery = dateDelivery;
        this.name = userName;
        this.surname = userSurname;
        this.patronymic = userPatronymic;
        this.email = userEmail;
    }
}
