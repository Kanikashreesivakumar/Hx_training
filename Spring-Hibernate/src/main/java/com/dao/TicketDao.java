package com.dao;

import com.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

public interface TicketDao {
    List<Ticket> findAll(String customerUsername);
    void save(Ticket ticket,String customerUsername);
    Ticket getById(int id ,String customerUsername);
    void update(Ticket ticket);
}
