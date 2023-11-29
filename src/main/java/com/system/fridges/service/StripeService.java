package com.system.fridges.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.system.fridges.models.Subscription;
import com.system.fridges.models.transferObjects.stripeObjects.StripeCharge;
import com.system.fridges.models.transferObjects.stripeObjects.StripeToken;
import com.system.fridges.repositories.SubscriptionRepository;
import com.system.fridges.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${stripe.secret-key}")
    private String secretKey;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public StripeToken createCardToken(StripeToken model) throws StripeException {
        Map<String, Object> card = new HashMap<>();
        card.put("number", model.cardNumber);
        card.put("exp_month", Integer.parseInt(model.expMonth));
        card.put("exp_year", Integer.parseInt (model.expYear));
        card.put("cvc", model.cvv);

        HashMap<String, Object> params= new HashMap<>();
        params.put ("card", card);

        Token token = Token.create(params);
        Token.create (params);

        if (token != null && token.getId() != null) {
            model.success = true;
            model.token = token.getId();
        }
        return model;
    }

    public StripeCharge charge(StripeCharge chargeRequest, String userEmail) throws StripeException {
        Subscription subscription = new Subscription(Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusMonths(6)), 100, userRepository.findUserByEmail(userEmail));
        subscriptionRepository.save(subscription);

        chargeRequest.success = false;
        Map<String, Object> chargeParams= new HashMap<>();
        chargeParams.put("amount", (int) (chargeRequest.amount = 100));
        chargeParams.put("currency", "USD");
        chargeParams.put("description", "Payment for id+ chargeRequest.getAdditionalInfo().getOrDefault(key: , defaultValue: ));");
        chargeParams.put("source", chargeRequest.stripeToken);

        Map<String, Object> metaData= new HashMap<>();
        metaData.put("id", chargeRequest.chargeId);
        metaData.putAll(chargeRequest.addictionInfo);

        chargeParams.put("metadata", metaData);
        Charge charge = Charge.create(chargeParams);
        chargeRequest.message = (charge.getOutcome ().getSellerMessage());

        if (charge.getPaid ()) {
            chargeRequest.chargeId = charge.getId();
            chargeRequest.success = true;
        }
        return chargeRequest;
    }
}
