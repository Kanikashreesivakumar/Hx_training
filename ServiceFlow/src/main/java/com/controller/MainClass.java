package com.controller;

import com.Exception.ResourceNotFoundException;
import com.config.HibernateConfig;
import com.enums.Priority;
import com.enums.Status;
import com.model.Ticket;
import com.service.TicketService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Session session =  HibernateConfig.getSessionFactory().openSession();

        Scanner sc = new Scanner(System.in);
        TicketService ticketService = new TicketService(session);

        while(true){
            System.out.println("1. Add Ticket");
            System.out.println("2. Delete Ticket by id");
            System.out.println("3. Fetch all Tickets");
            System.out.println("4. Update Ticket");
            System.out.println("0. Exit ");
            int op = sc.nextInt();
            if(op ==0)
                break;
            switch(op){
                case 1:
                    // Take input or prepare urself
                    Ticket ticket = new Ticket();
                    ticket.setSubject("Internet shutdown");
                    ticket.setDetails("internet not working since yesterday. ");
                    ticket.setStatus(Status.OPEN);
                    ticket.setPriority(Priority.HIGH);
                    ticketService.insert(ticket);
                    System.out.println("Ticket Added");
                    break;
                case 2:
                    System.out.println("Enter ticket id to deete record");
                    int id =sc.nextInt();
                    try {
                        ticketService.deleteRecord(id);
                        System.out.println("Record deleted");
                    }catch(ResourceNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("----------All Tickets----------");
                    List<Ticket> list = ticketService.getAllTickets();
                    list.forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Enter the id to update:");
                     id = sc.nextInt();
                     try {
                         ticket = ticketService.getById(id);
                         System.out.println("Existing ticket record"+ticket);
                         sc.nextLine();
                         System.out.println("enter subject:");
                         ticket.setSubject(sc.nextLine());
                         System.out.println("Enter details:");
                         ticket.setDetails(sc.nextLine());
                         System.out.println("Enter priority:");
                         ticket.setPriority(Priority.valueOf(sc.next().toUpperCase()));
                         ticketService.insert(ticket);

                     }
                     catch(ResourceNotFoundException e){
                         System.out.println("ID not found");
                     }

                    break;

                default:
                    System.out.println("invalid option. try again");
                    break;
            }
        }

        sc.close();
        session.close();

    }
}