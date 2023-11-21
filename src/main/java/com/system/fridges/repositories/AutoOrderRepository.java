package com.system.fridges.repositories;

import com.system.fridges.models.AutoOrder;
import com.system.fridges.models.transferObjects.FridgeOrder;
import com.system.fridges.models.transferObjects.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoOrderRepository extends JpaRepository<AutoOrder, Integer> {

    @Query(value = "SELECT ar.date_delivery, us.name, us.surname, us.patronymic, us.email FROM auto_order as ar " +
            "LEFT JOIN access as ac ON ar.access_order = ac.access_id " +
            "LEFT JOIN user as us ON ac.user_access = us.user_id where ac.fridge_access = :fridgeId", nativeQuery = true)
    List<FridgeOrder> getInfoOrdersForFridgeById(@Param("fridgeId") int fridgeId);

    @Query(value = "SELECT ar.date_delivery, ar.number, ac.fridge_access, p.name, p.weight FROM auto_order as ar " +
            "LEFT JOIN access as ac ON ar.access_order = ac.access_id " +
            "LEFT JOIN product as p ON ar.product_id = p.product_id WHERE ac.user_access = :userId", nativeQuery = true)
    List<UserOrder> getAllOrdersForUserById(@Param("userId") int userId);
}
