package com.system.fridges.service.interfaces;

import com.system.fridges.models.Subscription;
import com.system.fridges.models.User;

import java.util.List;

public interface SubscriptionService {

    List<Subscription> getAllSubscriptions();
    Subscription getSubscriptionById(int subscriptionId);

    void saveSubscription(Subscription subscription);

    void deleteSubscription(int subscriptionId);
}
