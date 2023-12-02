package com.system.fridges.controllers;


import com.system.fridges.models.transferObjects.stripeObjects.StripeCharge;
import com.system.fridges.models.transferObjects.stripeObjects.StripeToken;
import com.system.fridges.service.StripeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentControllerTest {

    @InjectMocks
    private PaymentController paymentController;

    @Mock
    private StripeService stripeService;

    @Test
    public void testCreatePaymentToken() throws Exception {
        StripeToken stripeToken = new StripeToken();
        when(stripeService.createCardToken(stripeToken)).thenReturn(new StripeToken());

        ResponseEntity<StripeToken> responseEntity = paymentController.createPaymentToken(stripeToken);

        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testCharge() throws Exception {
        StripeCharge stripeCharge = new StripeCharge();
        when(stripeService.charge(stripeCharge)).thenReturn(new StripeCharge());

        ResponseEntity<StripeCharge> responseEntity = paymentController.charge(stripeCharge);

        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
