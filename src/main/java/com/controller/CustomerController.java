package com.controller;

import com.model.Customer;
import com.service.CustomerService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CustomerController {

    public static void main(String[] args) {
        // Reach out to Service class : Create an Object
        CustomerService customerService = new CustomerService();
        System.out.println("--- ALL Customers ----");
        List<Customer> list =  customerService.getAllCustomers();
        list.forEach(System.out :: println);

        try {
            System.out.println("--- Customers by City ---");
            List<Customer> list1 = customerService.getCustomersByCity("");
            list1.forEach(System.out::println);
        }
        catch(SQLException e){
            System.out.println("ERROR: " + e.getSQLState() + ": " + e.getMessage());
        }

        try {
            System.out.println("---Total customers---");
            System.out.println("Enter the city name:");
            Scanner s= new Scanner(System.in);
            String city =s.nextLine();
            int total =customerService.getTotalCustomersByCity(city);
            System.out.println("Total employees:"+total);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}