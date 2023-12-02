package com.system.fridges.repositories;

import com.system.fridges.models.Food;
import com.system.fridges.models.transferObjects.foodObjects.FoodInFridge;
import com.system.fridges.models.transferObjects.foodObjects.SpoiledFood;
import com.system.fridges.models.transferObjects.userObjects.UserFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query(value = "SELECT f.name, f.number_boxes, f.date_validity, t.end_date, ac.fridge_access " +
            "FROM food as f LEFT JOIN transaction as t  ON f.transaction_id = t.transaction_id " +
            "LEFT JOIN access as ac ON ac.access_id = t.access WHERE ac.user_access = :userId", nativeQuery = true)
    List<UserFood> getAllFoodUserById(@Param("userId") int userId);

    @Query(nativeQuery = true, name = "SpoiledFoodQuery")
    List<SpoiledFood> getSpoiledFoodByFridgeId(@Param("fridgeId") int fridgeId);

    @Query(nativeQuery = true, name = "FoodInFridgeQuery")
    List<FoodInFridge> getAllFoodForFridge(@Param("fridgeId") int fridgeId);

}


