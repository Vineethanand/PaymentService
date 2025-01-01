package com.product.paymentservice.services;

import com.product.paymentservice.adapters.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    /*
    Ideal flow of paymentservice
    1. Call Order Service
    2. Get Order details
    3. Verify amount
    4. Call PG to generate the payment link
    5. return paymentLink
     */
    public String initatePayment(String email, String phoneno, String orderid, Long amount)
    {
        return paymentGateway.generatePaymentLink(email, phoneno, orderid, amount);
    }
}
