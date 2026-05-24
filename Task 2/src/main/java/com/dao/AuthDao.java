package com.dao;

import org.springframework.security.core.userdetails.User;

public interface AuthDao {
    User login(String username, String password);
}
