package com.system.fridges.service.utils;

import com.system.fridges.models.transferObjects.AutoOrderRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Delivety {

    @Value("${delivety.api.url}")
    private String delivetyApiUrl; // Додаємо в application.properties або application.yml delivety.api.url=https://api.delivety.com/orders

    public void doAutoOrdering(AutoOrderRequest autoOrderRequest) {
            autoOrderRequest.access_token = "yUk2EzNE3MLzYuyTnEK3N4zc";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<AutoOrderRequest> request = new HttpEntity<>(autoOrderRequest, headers);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject("http://smart2.delivety.com/hooks/catch/bx3sl8kl43", request, String.class);
    }
}
