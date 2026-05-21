package com.service;

import com.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public String processPayment(Payment payment){
        return payment.process();
    }
}
