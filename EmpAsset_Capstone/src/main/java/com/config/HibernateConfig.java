package com.config;

import com.model.*;
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
         configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");


         configuration.setProperty("hibernate.hbm2ddl.auto", "update");

         configuration.addAnnotatedClass(User.class);
         configuration.addAnnotatedClass(Admin.class);
         configuration.addAnnotatedClass(AssetAllocation.class);
         configuration.addAnnotatedClass(Asset.class);
         configuration.addAnnotatedClass(AssetCategory.class);
         configuration.addAnnotatedClass(Employee.class);
         configuration.addAnnotatedClass(ServiceRequest.class);
         configuration.addAnnotatedClass(AuditRequest.class);
         configuration.addAnnotatedClass(AssetRequest.class);


         sessionFactory = configuration.buildSessionFactory();
     }
     return sessionFactory;

    }

    public static void closeFactory(){
        sessionFactory.close();
    }
}
