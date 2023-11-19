package com.system.fridges.repositories;

import com.system.fridges.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
}
