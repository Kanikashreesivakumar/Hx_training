package com.controller;

import com.Exception.ResourceNotFoundException;
import com.Service.UserService;
import com.config.HibernateConfig;
import com.enums.Role;
import com.model.User;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class MainClass
{

    public static void main(String[]args){
        Session session = HibernateConfig.getSessionFactory().openSession();
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        while(true){
            System.out.println("1. Add User");
            System.out.println("2. Delete User by ID");
            System.out.println("3. Fetch all User");
            System.out.println("4. Update User");
            System.out.println("0. Exit");
            int op =sc.nextInt();
            if(op==0)
                break;

            switch(op){
                case 1:
                    User user =new User();
                    user.setUsername("USER1");
                    user.setPassword("pass123");
                    user.setRole(Role.ADMIN);
                    userService.insert(user);
                    System.out.println("User Added");
                    break;

                case 2:
                    System.out.println("Enter the User ID to delete record:");
                    int id =sc.nextInt();
                    try{
                        userService.deleteRecord(id);
                        System.out.println("Reccord deleted");

                    }catch(ResourceNotFoundException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("-------All Users---------");
                    List<User> list = userService.getAllUsers();
                    list.forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Enter the ID to Update");
                    id=sc.nextInt();
                    try{
                        user = userService.getById(id);
                        System.out.println("Existing user record"+user);
                        sc.nextLine();
                        System.out.println("Enter the Updated Username:");
                        user.setUsername(sc.nextLine());
                        System.out.println("Enter the Updated Password:");
                        user.setPassword(sc.nextLine());
                        System.out.println("Enter Role");
                        user.setRole(Role.valueOf(sc.next().toUpperCase()));
                        userService.update(user);
                    }
                    catch(ResourceNotFoundException e){
                        System.out.println("ID not found");
                    }
                    break;

                default:
                    System.out.println("Invalid option, Try again later");
                    break;

            }
        }
        sc.close();
        session.close();
    }
}
