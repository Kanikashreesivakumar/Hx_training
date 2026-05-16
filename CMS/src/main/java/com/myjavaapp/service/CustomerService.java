package com.myjavaapp.service;

import com.myjavaapp.model.Customer;
import com.myjavaapp.repository.CustomerRepository;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {

    CustomerRepository customerRepository = new CustomerRepository();

    public List<Customer> getAllCustomerView() {
        return customerRepository.getAllCustomers();
    }

    public List<Customer> getCustomerByCity(String s) throws SQLException {
        return customerRepository.getCustomersByCity(s);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}