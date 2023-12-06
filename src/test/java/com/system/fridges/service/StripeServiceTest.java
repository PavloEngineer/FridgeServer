package com.system.fridges.service;

import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.system.fridges.models.transferObjects.stripeObjects.StripeRequest;
import com.system.fridges.models.transferObjects.stripeObjects.StripeResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StripeServiceTest {

    @InjectMocks
    private StripeService stripeService;

    @Mock
    private Customer customer;

    @Mock
    private PaymentIntent paymentIntent;

    @Test
    void testCreatePaymentIntent() throws StripeException {
        StripeRequest request = new StripeRequest();
        request.setEmail("test@example.com");
        request.setAmount(100L);

        StripeResponse response = new StripeResponse();

        assertNotNull(response);
    }
}
