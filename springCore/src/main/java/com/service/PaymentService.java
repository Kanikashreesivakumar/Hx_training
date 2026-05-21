package com.service;

import com.model.Payment;

public class PaymentService {
    public String processPayment(Payment payment){
        return payment.process();
    }
}
