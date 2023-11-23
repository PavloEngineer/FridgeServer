package com.system.fridges.controllers;

import com.stripe.exception.StripeException;
import com.system.fridges.models.Subscription;
import com.system.fridges.models.transferObjects.StripeCharge;
import com.system.fridges.models.transferObjects.StripeToken;
import com.system.fridges.service.StripeService;
import com.system.fridges.service.interfaces.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private StripeService stripeService;

    @PostMapping("/card/token")
    @ResponseBody
    public StripeToken createPaymentToken(@RequestBody StripeToken model) {
        try {
            return stripeService.createCardToken(model);
        } catch (StripeException e) {
            System.out.print(e.getMessage());
        }
        return null;
    }

    @PostMapping("/charge")
    @ResponseBody
    public StripeCharge charge(@RequestBody StripeCharge model, int userId) {
        try {
            return stripeService.charge(model, userId);
        } catch (StripeException e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
}
