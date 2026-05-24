package com.dao_impl;

import com.dao.AuthDao;
import com.exception.UserNotFoundException;
import com.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class AuthDaoImpl implements AuthDao {


    @PersistenceContext
    private EntityManager em;

    @Override
    public User login(String username, String password) {
        Query query = em.createQuery("select u from User u where u.username=:username and u.password=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            return (User) query.getSingleResult();
        } catch (Exception e) {
            throw new UserNotFoundException("Invalid Credentials");
        }
    }
}
