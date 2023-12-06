package com.system.fridges.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Token;
import com.stripe.param.PaymentIntentCreateParams;
import com.system.fridges.models.Subscription;
import com.system.fridges.models.transferObjects.stripeObjects.StripeCharge;
import com.system.fridges.models.transferObjects.stripeObjects.StripeRequest;
import com.system.fridges.models.transferObjects.stripeObjects.StripeResponse;
import com.system.fridges.models.transferObjects.stripeObjects.StripeToken;
import com.system.fridges.repositories.SubscriptionRepository;
import com.system.fridges.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${stripe.api.publicKey}")
    private String publicKey;

    void init() {
        Stripe.apiKey = publicKey;
    }

     public StripeResponse createPaymentIntent(StripeRequest request)
            throws StripeException {

         Customer customer = new Customer();
         customer.setEmail(request.getEmail());
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(request.getAmount() * 100L)
                        .setCurrency("usd")
                        .setCustomer(customer.getId())
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams
                                        .AutomaticPaymentMethods
                                        .builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();
        PaymentIntent intent =
                PaymentIntent.create(params);
        return new StripeResponse(intent.getId(),
                intent.getClientSecret());
    }
}
