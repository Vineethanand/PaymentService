package com.product.paymentservice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DummyProductService {

    private RestTemplate restTemplate;

    public DummyProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getProductById(String productId) {
        return restTemplate.getForObject("http://PRODUCTSERVICEDEMO/products/" + productId, String.class);
    }
}
