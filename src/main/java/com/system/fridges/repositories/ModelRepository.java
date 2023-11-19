package com.system.fridges.repositories;

import com.system.fridges.models.Model;
import com.system.fridges.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
