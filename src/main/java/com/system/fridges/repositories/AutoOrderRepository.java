package com.system.fridges.repositories;

import com.system.fridges.models.AutoOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoOrderRepository extends JpaRepository<AutoOrder, Integer> {
}
