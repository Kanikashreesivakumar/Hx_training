package com.dao_impl;

import com.dao.AdminDao;
import com.exception.ResourceNotFoundException;
import com.model.Admin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminDaoImpl implements AdminDao {
    private final JdbcTemplate jdbcTemplate;

    public AdminDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private RowMapper<Admin> mapper() {

        return (rs, rowNum) -> {

            Admin admin = new Admin();

            admin.setId(rs.getInt("id"));
            admin.setAdminName(rs.getString("adminName"));
            admin.setPhone(rs.getInt("phone"));
            admin.setPosition(rs.getString("position"));

            return admin;
        };
    }


    @Override
    public void insert(Admin admin) {
        String sql = "insert into admin(adminName,phone,position)values(?,?,?)";
        jdbcTemplate.update(
                sql,
                admin.getAdminName(),
                admin.getPhone(),
                admin.getPosition()
        );
        System.out.println("Admin Added");
    }

    @Override
    public List<Admin> getAllAdmins() {
        String sql = "select * from admin";
        return jdbcTemplate.query(sql, mapper());
    }


    @Override
    public void deleteById(int id) throws ResourceNotFoundException {
        String sql = "delete from admin where id=?";
        int numRow = jdbcTemplate.update(sql, id);

        if (numRow == 0) {
            throw new ResourceNotFoundException("Invalid ID");
        }
        System.out.println("Admin deleted");

    }

    @Override
    public Admin getAdminById(int id) throws ResourceNotFoundException {
        String sql = "select * from admin where id=?";
        List<Admin> list = jdbcTemplate.query(sql, mapper(), id);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Invalid ID");
        }
        return list.get(0);
    }

        @Override
        public void update(Admin admin) throws ResourceNotFoundException {

            String sql =
                    "update admin set adminName=?,phone=?,position=? where id=?";

            int numRow = jdbcTemplate.update(
                    sql,
                    admin.getAdminName(),
                    admin.getPhone(),
                    admin.getPosition(),
                    admin.getId()
            );

            if (numRow == 0) {

                throw new ResourceNotFoundException("Invalid ID");
            }

            System.out.println("Admin Updated");
        }
    }

