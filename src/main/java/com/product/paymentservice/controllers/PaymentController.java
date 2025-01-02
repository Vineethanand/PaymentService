package com.product.paymentservice.controllers;

import com.product.paymentservice.dtos.PaymentInputDto;
import com.product.paymentservice.services.DummyProductService;
import com.product.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;
    private DummyProductService productService;

    public PaymentController(PaymentService paymentService, DummyProductService productService)
    {
        this.paymentService = paymentService;
        this.productService = productService;
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

    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable String id)
    {
        return productService.getProductById(id);
    }
}
