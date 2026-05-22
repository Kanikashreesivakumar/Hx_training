package com.app;

import com.Config.AppConfig;
import com.dao.IncidentDao;
import com.dao_impl.IncidentDaoImpl;
import com.enums.IncidentStatus;
import com.enums.IncidentType;
import com.exception.ResourceNotFoundException;
import com.model.Incident;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
      Scanner sc = new Scanner(System.in);

        IncidentDao incidentDao=context.getBean(IncidentDaoImpl.class);
        //incidentDao.insert(new Incident(301,IncidentType.ABUSE,"incidnet details", IncidentStatus.ACTIVE));
/*
        System.out.println("Enter ID to delete incident");
        int id=sc.nextInt();
        try{
            incidentDao.deleteById(id);
        }catch(ResourceNotFoundException e){
            System.out.println(e.getMessage());
        }
*/

        incidentDao.getAll().forEach(System.out::println);
        sc.close();
        context.close();
    }
}