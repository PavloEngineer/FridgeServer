package com.system.fridges.repositories;

import com.system.fridges.models.Food;
import com.system.fridges.models.transferObjects.FoodInFridge;
import com.system.fridges.models.transferObjects.SpoiledFood;
import com.system.fridges.models.transferObjects.UserFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query(value = "SELECT f.name, f.number_boxes, f.date_validity, t.end_date, ac.fridge_access " +
            "FROM food as f LEFT JOIN transaction as t  ON f.transaction_id = t.transaction_id " +
            "LEFT JOIN access as ac ON ac.access_id = t.access WHERE ac.user_access = :userId", nativeQuery = true)
    List<UserFood> getAllFoodUserById(@Param("userId") int userId);

    @Query(value = "SELECT f.name, f.number_boxes, f.date_validity, t.end_date, ac.user_access " +
            "FROM food as f LEFT JOIN transaction as t  ON f.transaction_id = t.transaction_id " +
            "LEFT JOIN access as ac ON ac.access_id = t.access " +
            "WHERE ac.fridge_access = :fridgeId AND f.date_validity < current_date()", nativeQuery = true)
    List<SpoiledFood> getSpoiledFoodByFridgeId(@Param("fridgeId") int fridgeId);

    @Query(value = "SELECT f.name, f.number_boxes, f.date_validity, t.end_date, us.name, us.surname, us.patronymic, us.email \n" +
            "            FROM food as f LEFT JOIN transaction as t  ON f.transaction_id = t.transaction_id \n" +
            "            LEFT JOIN access as ac ON ac.access_id = t.access  LEFT JOIN user as us ON us.user_id = ac.user_access\n" +
            "            WHERE ac.fridge_access = :fridgeId", nativeQuery = true)
    List<FoodInFridge> getAllFoodForFridge(@Param("fridgeId") int fridgeId);
}
