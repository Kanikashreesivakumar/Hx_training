package com.dao_impl;

import com.dao.CustomerDao;
import com.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class CustomerDaoImpl implements CustomerDao {
      @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Customer getByUsername(String customerUsername) {
       String sql="select c from Customer c where c.user.username=?1";
       TypedQuery<Customer> query= entityManager.createQuery(sql,Customer.class);
       query.setParameter(1,customerUsername);
       return query.getSingleResult();

    }
}
