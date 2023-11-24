package com.system.fridges.controllers;

import com.stripe.exception.StripeException;
import com.system.fridges.models.transferObjects.stripeObjects.StripeCharge;
import com.system.fridges.models.transferObjects.stripeObjects.StripeToken;
import com.system.fridges.service.StripeService;
import com.system.fridges.service.utils.Constants;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("*/subscription/buy")
public class PaymentController {

    @Autowired
    private StripeService stripeService;

    @Autowired
    private HttpSession session;

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
    public StripeCharge charge(@RequestBody StripeCharge model) {
        try {
            return stripeService.charge(model, (Integer) session.getAttribute(Constants.USER_ID));
        } catch (StripeException e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
}
