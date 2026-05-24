package com.dao;

import com.model.User;

public interface AuthDao {
    User login(String username , String password);
}
