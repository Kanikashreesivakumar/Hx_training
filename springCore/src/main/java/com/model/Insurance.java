package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Insurance {

    private CarInsurance carInsurance;

    private BikeInsurance bikeInsurance;
    @Autowired
    public Insurance(CarInsurance carInsurance, BikeInsurance bikeInsurance) {
        this.carInsurance = carInsurance;
        this.bikeInsurance = bikeInsurance;
    }

    public void details(){
        System.out.println("insurance details");
    bikeInsurance.details();
    carInsurance.details();
    }

}
