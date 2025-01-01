package com.product.paymentservice.controllers;

import com.product.paymentservice.dtos.PaymentInputDto;
import com.product.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }

    @PostMapping
    public String initiatePayment(@RequestBody PaymentInputDto paymentInputDto)
    {
        return paymentService.initatePayment(paymentInputDto.getEmail(), paymentInputDto.getPhoneno(), paymentInputDto.getOrderid(), paymentInputDto.getAmount());
    }

    @PostMapping("/webhook")
    public String listentoWebhook(@RequestBody String webhookEvent)
    {
        System.out.println(webhookEvent);
        return "OK";
    }
}
