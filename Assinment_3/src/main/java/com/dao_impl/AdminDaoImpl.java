package com.dao_impl;

import com.dao.AdminDao;
import com.exception.ResourceNotFoundException;
import com.model.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class AdminDaoImpl implements AdminDao {
   @PersistenceContext
   private EntityManager em;
    @Override
    public void insert(Admin admin) {
        em.persist(admin);
        System.out.println("Admin Added");

    }


    @Override
    public List<Admin> getAllAdmins() {
        String jpql="select a from Admin a";
        return em.createQuery(jpql, Admin.class)
                .getResultList();
    }

    @Override
    public void deleteById(int id) throws ResourceNotFoundException {

        Admin admin=em.find(Admin.class,id);
        if(admin == null){
            throw new ResourceNotFoundException("Invalid ID");
        }
        em.remove(admin);
        System.out.println("Admin Deleted");

    }

    @Override
    public Admin getAdminById(int id) throws ResourceNotFoundException {
        Admin admin = em.find(Admin.class,id);

        if(admin == null){
            throw new ResourceNotFoundException("Invalid Id");
        }return admin;

    }

    @Override
    public void update(Admin admin) throws ResourceNotFoundException {
     Admin existingAdmin =em.find(Admin.class,admin.getId());

     if(existingAdmin== null){
         throw new ResourceNotFoundException("Invalid ID");
     }

     existingAdmin.setAdminName(admin.getAdminName());
     existingAdmin.setPhone(admin.getPhone());
     existingAdmin.setPosition(admin.getPosition());
     em.merge(existingAdmin);

     System.out.println("Admin Updated");
    }
}

