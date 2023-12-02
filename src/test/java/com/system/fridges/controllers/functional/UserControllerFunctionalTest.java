//package com.system.fridges.controllers.functional;
//
//import com.system.fridges.models.AutoOrder;
//import com.system.fridges.models.Food;
//import com.system.fridges.models.Transaction;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.time.LocalDateTime;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class UserControllerFunctionalTest {
//
//
//    @Test
//    void addOrdersReturnsValidResponse() {
//        // Arrange
//        List<AutoOrder> orders = Collections.singletonList(new AutoOrder(LocalDateTime.now(), 2, accessRepository.findById(1).get(), productRepository.findById(1).get()));
//
//        // Act
//        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/fridge/autoOrdering/addOrder", orders, Void.class);
//
//        // Assert: Assuming a successful request (HttpStatus.OK)
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//    }
//
//    @Test
//    void addFoodReturnsValidResponse() {
//        // Arrange
//        List<Food> food = Collections.singletonList(new Food(new Date(), 2, "Food", new Transaction()));
//
//        // Act
//        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/fridge/addFood", food, Void.class);
//
//        // Assert: Assuming a successful request (HttpStatus.OK)
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//    }
//}
