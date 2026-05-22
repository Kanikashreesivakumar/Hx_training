package com.dao_impl;

import com.dao.CustomerDao;
import com.dao.TicketDao;
import com.enums.Status;
import com.exception.InvalidOwnershipException;
import com.exception.ResourceNotFoundException;
import com.model.Customer;
import com.model.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class TicketDaoImpl implements TicketDao {
@PersistenceContext
private EntityManager entityManager;

private CustomerDao customerDao;
    @Autowired
public void setCustomerDao(CustomerDao customerDao){
    this.customerDao = customerDao;
}
    @Override
    public List<Ticket> findAll(String customerUsername) {
        TypedQuery<Ticket> query = entityManager.createQuery("select t from Ticket t where t.customer.user.username=:username",Ticket.class);
        query.setParameter("username",customerUsername);
        return query.getResultList();
    }

    @Override
    public void save(Ticket ticket, String customerUsername) {
        Customer customer =customerDao.getByUsername(customerUsername);
        ticket.setCustomer(customer);
        ticket.setStatus(Status.OPEN);
        entityManager.persist(ticket);
    }

    @Override
    public Ticket getById(int id, String customerUsername) {

        Ticket ticket= entityManager.find(Ticket.class,id);
        if(ticket==null)
            throw new ResourceNotFoundException("Invalid id");
        if(!(ticket.getCustomer().getUser().getUsername().equals(customerUsername))){
            throw new InvalidOwnershipException("You do not won this ticket");
        }
        return ticket;
    }

    @Override
    public void update(Ticket ticket) {
       entityManager.merge(ticket);
    }
}
