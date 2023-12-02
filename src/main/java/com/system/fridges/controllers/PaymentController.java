package com.system.fridges.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.system.fridges.models.transferObjects.stripeObjects.StripeCharge;
import com.system.fridges.models.transferObjects.stripeObjects.StripeToken;
import com.system.fridges.service.StripeService;
import com.system.fridges.service.utils.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription")
public class PaymentController {

    @Autowired
    private StripeService stripeService;

    @PostMapping("/buy/card/token")
    @ResponseBody
    public ResponseEntity<StripeToken> createPaymentToken(@RequestBody StripeToken model) {
        try {
            return ResponseEntity.ok(stripeService.createCardToken(model));
        } catch (StripeException e) {
            System.out.print(e.getMessage());
        }
        return null;
    }

    @PostMapping("/charge")
    @ResponseBody
    public ResponseEntity<StripeCharge> charge(@RequestBody StripeCharge model) {
        try {
            return ResponseEntity.ok(stripeService.charge(model));
        } catch (StripeException e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
}
