package com.product.paymentservice.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfigs {

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Bean
    public RazorpayClient createrazorpayClient() throws RazorpayException {
        return new RazorpayClient(razorpayKeyId, razorpayKeySecret);
    }
}
