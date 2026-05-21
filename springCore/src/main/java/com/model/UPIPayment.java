package com.model;

import org.springframework.stereotype.Component;

@Component
public class UPIPayment implements Payment {

    @Override
    public String process(){
        return"UPI PROCESS";
    }
}
