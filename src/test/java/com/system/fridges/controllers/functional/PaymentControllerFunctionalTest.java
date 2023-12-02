package com.system.fridges.controllers.functional;

import com.stripe.exception.StripeException;
import com.system.fridges.models.transferObjects.stripeObjects.StripeToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentControllerFunctionalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreatePaymentToken() {
        // Arrange
        StripeToken stripeToken = new StripeToken();
        stripeToken.setCardNumber("4242424242424242");
        stripeToken.setCvv("234");
        stripeToken.setExpMonth("12");
        stripeToken.setExpYear("2024");
        stripeToken.setUserName("pasakane990@gmail.com");
        stripeToken.setSuccess(true);

        // Act
        ResponseEntity<StripeToken> responseEntity = restTemplate.postForEntity(
                "/subscription/buy/card/token", stripeToken, StripeToken.class);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(stripeToken, responseEntity.getBody());
    }

}
