package com.system.fridges.service.utils;

import com.system.fridges.models.transferObjects.orderObjects.AutoOrderRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Delivety {

    @Value("${delivety.api.url}")
    private String delivetyApiUrl;

    public void doAutoOrdering(AutoOrderRequest autoOrderRequest) {
            autoOrderRequest.access_token = "yUk2EzNE3MLzYuyTnEK3N4zc";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<AutoOrderRequest> request = new HttpEntity<>(autoOrderRequest, headers);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject("https://smart2.delivety.com/hooks/catch/bx3sl8kl43", request, String.class);
    }
}
