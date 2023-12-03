package com.system.fridges.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import com.system.fridges.models.transferObjects.stripeObjects.StripeCharge;
import com.system.fridges.models.transferObjects.stripeObjects.StripeRequest;
import com.system.fridges.models.transferObjects.stripeObjects.StripeResponse;
import com.system.fridges.models.transferObjects.stripeObjects.StripeToken;
import com.system.fridges.service.StripeService;
import com.system.fridges.service.utils.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
public class PaymentController {
    @Value("${stripe.api.publicKey}")
    private String publicKey;

    @Autowired
    private StripeService stripeService;

    @PostMapping("/buy/card")
    public ResponseEntity<StripeResponse> createPaymentIntent(@RequestBody StripeRequest request)
            throws StripeException {
        return ResponseEntity.ok(stripeService.createPaymentIntent(request));
    }
}
