package com.system.fridges.controllers;

import com.stripe.exception.StripeException;
import com.system.fridges.models.transferObjects.stripeObjects.StripeRequest;
import com.system.fridges.models.transferObjects.stripeObjects.StripeResponse;
import com.system.fridges.service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
public class PaymentController {

    @Autowired
    private StripeService stripeService;

    @PostMapping("/buy/card")
    public ResponseEntity<StripeResponse> createPaymentIntent(@RequestBody StripeRequest request)
            throws StripeException {
        return ResponseEntity.ok(stripeService.createPaymentIntent(request));
    }
}
