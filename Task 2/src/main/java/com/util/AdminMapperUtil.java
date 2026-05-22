package com.util;

import com.model.Admin;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AdminMapperUtil implements RowMapper<Admin> {

    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {

        Admin admin = new Admin();
        admin.setId(rs.getInt("id"));
        admin.setAdminName(rs.getString("adminName"));
        admin.setPhone(rs.getInt("phone"));
        admin.setPosition(rs.getString("position"));

        return admin;
    }
}
