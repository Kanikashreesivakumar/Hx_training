package com.main;

import com.config.AppConfig;
import com.model.Insurance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[]args){
        System.out.println("Spring framework ");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
Insurance insurance =context.getBean(Insurance.class);
insurance.details();
        context.close();
    }

}

