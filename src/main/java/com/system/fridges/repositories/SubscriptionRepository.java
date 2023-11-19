package com.system.fridges.repositories;

import com.system.fridges.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
