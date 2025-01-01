package com.product.paymentservice.adapters;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    String generatePaymentLink(String email, String phoneno, String orderid, Long amount);
}
