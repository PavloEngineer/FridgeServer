package com.system.fridges.models.transferObjects.fridgeObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class FridgeOrder {

    @JsonProperty("order_id")
    private int order_id;

    @JsonProperty("date_delivery")
    private LocalDateTime date_delivery;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("patronymic")
    private String patronymic;

    @JsonProperty("email")
    private String email;
}
