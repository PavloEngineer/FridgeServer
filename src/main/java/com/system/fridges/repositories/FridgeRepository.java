package com.system.fridges.repositories;

import com.system.fridges.models.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FridgeRepository extends JpaRepository<Fridge, Integer> {
}
