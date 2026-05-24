package com.dao;

import com.exception.ResourceNotFoundException;
import com.model.Admin;
import com.MainApp;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AdminDao {

    void insert(Admin admin);
    List<Admin> getAllAdmins();
    void deleteById(int id) throws ResourceNotFoundException;

    Admin getAdminById(int id) throws ResourceNotFoundException;
    void update(Admin admin) throws ResourceNotFoundException;
}
