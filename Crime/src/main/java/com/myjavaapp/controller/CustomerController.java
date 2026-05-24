package com.myjavaapp.controller;

import com.myjavaapp.model.Customer;
import com.myjavaapp.service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerController {
    public static void main(String[] args){

        CustomerService customerService = new CustomerService();
        System.out.println("----All Customers---");
      List<Customer> list=  customerService.getAllCustomerView();
       list.forEach(System.out :: println);

       try{
           System.out.println("---Customer by city---");
           List<Customer> list1 = customerService.getCustomerByCity("");
           list1.forEach(System.out::println);
       }catch (SQLException e){
           System.out.println("ERROR: "+e.getSQLState() +":"+e.getMessage());
       }
    }
}
