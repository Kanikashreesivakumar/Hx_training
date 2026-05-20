package com.service;

import com.Exception.InvalidOwnershipException;
import com.Exception.ResourceNotFoundException;
import com.enums.Status;
import com.model.Customer;
import com.model.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketService {

    private final Session session;
    private CustomerService customerService;

    public TicketService(Session session) {
        this.session = session;
        customerService = new CustomerService(session);
    }

    public void insert(Ticket ticket) {
        Transaction tx = session.beginTransaction();
        session.persist(ticket);
        tx.commit();

    }

    public void deleteRecord(int id) {

        Transaction tx = session.beginTransaction();
        Ticket ticket = session.find(Ticket.class, id);
        if (ticket == null) {
            tx.commit();
            throw new ResourceNotFoundException("Invalid ID given..");
        }
        session.remove(ticket);


        /* delete by using the HQL
           session.createMutationQuery("delete from where id=:id");
                     .setParameter("id",id)
                     .executeUpdate();
                     tx.commit();
         */

        tx.commit();
    }


    public List<Ticket> getAllTickets() {
        Transaction tx = session.beginTransaction();
        List<Ticket> list = session
                .createQuery("from Ticket", Ticket.class)
                .list();
        tx.commit();
        return list;

    }

    public Ticket getById(int id) {
        Transaction tx = session.beginTransaction();
        Ticket ticket = session.find(Ticket.class, id);
        tx.commit();
        if (ticket == null)
            throw new ResourceNotFoundException("Invalid id");

        return ticket;
    }

    public void addTicket(Ticket ticket, String customerUsername) {
        Customer customer = customerService.getByUsername(customerUsername);
        ticket.setCustomer(customer);
        ticket.setStatus(Status.OPEN);
        Transaction tx = session.beginTransaction();
        session.persist(ticket);
        tx.commit();
    }

    public void deleteById(int ticketId, String username) {
        Transaction tx = session.beginTransaction();
        Ticket ticket = session.find(Ticket.class, ticketId);
        tx.commit();

        if (ticket == null)

            throw new ResourceNotFoundException("Ticket Id invalid");
        Customer customer = customerService.getByUsername(username);
        if (ticket.getCustomer().getId() != customer.getId())
            throw new InvalidOwnershipException("Customer does not own this ticket,Deletion aborted");

        tx = session.beginTransaction();
        session.remove(ticket);
        tx.commit();


    }
}