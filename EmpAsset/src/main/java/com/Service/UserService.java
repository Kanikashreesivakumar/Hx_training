package com.Service;

import com.Exception.ResourceNotFoundException;
import com.config.HibernateConfig;
import com.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserService {

    public void insert(User user){

        Session session = HibernateConfig
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        session.persist(user);

        tx.commit();

        session.close();
    }

    public void deleteRecord(int id){

        Session session = HibernateConfig
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        User user = session.find(User.class, id);

        if(user == null){
            tx.commit();
            session.close();
            throw new ResourceNotFoundException("Invalid ID given");
        }

        session.remove(user);

        tx.commit();

        session.close();

        System.out.println("Record deleted");
    }

    public List<User> getAllUsers(){

        Session session = HibernateConfig
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        List<User> list = session
                .createQuery("from User", User.class)
                .list();

        tx.commit();

        session.close();

        return list;
    }

    public User getById(int id){

        Session session = HibernateConfig
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        User user = session.find(User.class, id);

        tx.commit();

        session.close();

        if(user == null)
            throw new ResourceNotFoundException("Invalid ID");

        return user;
    }

    public void update(User user){

        Session session = HibernateConfig
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        session.merge(user);

        tx.commit();

        session.close();

        System.out.println("User updated");
    }
}