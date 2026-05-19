package com.service;

import com.Exception.ResourceNotFoundException;
import com.model.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketService {
    private final Session session;
    public TicketService(Session session){
        this.session = session;
    }

    public void insert(Ticket ticket){
        Transaction tx= session.beginTransaction();
        session.persist(ticket);
        tx.commit();

    }

    public void deleteRecord(int id) {

        Transaction tx = session.beginTransaction();
        Ticket ticket = session.find(Ticket.class, id);
        if (ticket == null){
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
         List<Ticket> list= session
                           .createQuery("from Ticket",Ticket.class)
                           .list();
        tx.commit();
         return list;

    }

    public Ticket getById(int id) {
        Transaction tx = session.beginTransaction();
        Ticket ticket=session.find(Ticket.class,id);
                tx.commit();
                if(ticket==null)
        throw new ResourceNotFoundException("Invalid id");

        return ticket;
    }

}
