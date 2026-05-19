package com.config;

import com.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
     if(sessionFactory==null){
         Configuration configuration = new Configuration();
         configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/EmpAsset?createDatabaseIfNotExist=true");
         configuration.setProperty("hibernate.connection.username","root");
         configuration.setProperty("hibernate.connection.password","kani@2004");
         configuration.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
         // set the dialect
         configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");

         // If u want hibernate to generate the DB tables on the fly based on Model classes
         configuration.setProperty("hibernate.hbm2ddl.auto", "update");

         configuration.addAnnotatedClass(User.class);
         return configuration.buildSessionFactory();
     }
     return sessionFactory;

    }

    public static void closeFactory(){
        sessionFactory.close();
    }
}
