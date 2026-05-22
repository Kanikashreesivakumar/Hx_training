package com.dao;

import com.model.Customer;

public interface CustomerDao {
    Customer getByUsername(String customerUsername);
}
