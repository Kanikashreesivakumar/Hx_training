package com.dao_impl;

import com.dao.AuthDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class AuthDaoImpl implements AuthDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User login(String username, String password) {
       Query query=em.createQuery("select u from User u where u.username=:username , u..password=:password");
       query.setParameter("username",username);
       query.setParameter("password",password);

       return (User)query.getSingleResult();
    }
}
