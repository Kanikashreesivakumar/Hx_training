package com.main;

import com.config.AppConfig;
import com.model.Payment;
import com.model.UPIPayment;
import com.service.PaymentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PaymentMain {

    public static void main(String[]args){
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
      Payment payment1=  context.getBean(UPIPayment.class);
        Payment payment2=  context.getBean(UPIPayment.class);
        Payment payment3=  context.getBean(UPIPayment.class);
        System.out.println(payment1);
        System.out.println(payment2);
        System.out.println(payment3);
        PaymentService paymentService= context.getBean(PaymentService.class);
        System.out.println(paymentService.processPayment(payment1));
        System.out.println(paymentService.processPayment(payment2));
        System.out.println(paymentService.processPayment(payment3));
      context.close();
    }
}
