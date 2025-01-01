package com.product.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class PaymentInputDto {
    String email;
    String phoneno;
    String orderid;
    Long amount;
}
