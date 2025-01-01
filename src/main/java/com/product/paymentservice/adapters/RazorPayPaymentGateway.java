package com.product.paymentservice.adapters;

import com.razorpay.*;
import org.springframework.stereotype.Component;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;

@Component
public class RazorPayPaymentGateway implements PaymentGateway {

    private RazorpayClient razorPayClient;

    public RazorPayPaymentGateway(RazorpayClient razorPayClient) {
        this.razorPayClient = razorPayClient;
    }
    @Override
    public String generatePaymentLink(String email, String phoneno, String orderid, Long amount) {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1735809519);
        paymentLinkRequest.put("reference_id","TS1992");
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name", email);
        customer.put("contact", phoneno);
        customer.put("email", email);
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = null;
        try {
            payment = razorPayClient.paymentLink.create(paymentLinkRequest);
        } catch (RazorpayException e)
        {
            throw new RuntimeException(e);
        }
        return payment.get("short_url").toString();
        //razorPayClient.paymentLink.create(paymentLinkRequest);
    }
}
