package com.myjavaapp.controller;


import com.myjavaapp.enums.IncidentStatus;
import com.myjavaapp.enums.IncidentType;
import com.myjavaapp.enums.Role;
import com.myjavaapp.exception.UserNotFoundException;

import com.myjavaapp.model.Incident;
import com.myjavaapp.model.User;
import com.myjavaapp.service.UserService;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        System.out.println("--------CMS Portal: LOGIN----------");
        System.out.println("Enter Username ");
        String username = sc.next();
        System.out.println("Enter Password ");
        String password = sc.next();
        try {
            User user = userService.authenticateUser(username, password);
            System.out.println("Welcome to Crime Management Station : " + user.getUsername() );
            System.out.println("Role is " + user.getRole());
            if(user.getRole().equals(Role.OFFICER)){
                while(true){
                    System.out.println("1] View All Incidents");
                    System.out.println("2] Filter Incidents by Status");
                    System.out.println("3] Insert into the Incident");
                    int op = sc.nextInt();
                    switch(op){
                        case 1:
                            List<Incident> list = userService.viewAlIncidents();
                            for(Incident i : list){
                                System.out.println(i);
                            }
                            break;
                        case 2:
                            List<Incident> filterredList = userService.filterByStatus(IncidentStatus.ACTIVE);
                            for(Incident i : filterredList){
                                System.out.println(i);
                            }
                            break;


                        case 3:
                            sc.nextLine();

                            System.out.println("Enter Incident Type");
                            String incidentTypeInput = sc.nextLine().toUpperCase();
                            IncidentType incidentType = IncidentType.valueOf(incidentTypeInput);

                            System.out.println("Enter Progress Details");
                            String incidentProgress = sc.nextLine();

                            System.out.println("Enter Status");
                            String incidentStatusInput = sc.nextLine().toUpperCase();
                            IncidentStatus incidentStatus = IncidentStatus.valueOf(incidentStatusInput);

                            Incident newIncident = new Incident(0, incidentType, incidentProgress, incidentStatus);
                            userService.insertIncident(newIncident, user.getUsername());
                            System.out.println("Incident Added Successfully");
                            break;
                    }
                }
            }else{

            }
        } catch (SQLException | UserNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("\n");
        }
    }

}