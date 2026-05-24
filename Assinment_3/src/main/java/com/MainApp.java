package com;

import com.config.AppConfig;
import com.dao.AdminDao;
import com.dao.AuthDao;
import com.dao_impl.AdminDaoImpl;
import com.dao_impl.AuthDaoImpl;
import com.exception.ResourceNotFoundException;
import com.exception.UserNotFoundException;
import com.model.Admin;
import com.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AuthDao authDao = context.getBean(AuthDaoImpl.class);
        AdminDao adminDao=context.getBean(AdminDao.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("------LOGIN------");
        System.out.println("Enter Username:");
        String username =sc.nextLine();

        System.out.println("Enter Password");
        String password=sc.nextLine();
        try{
            User user = authDao.login(username ,password);
            switch(user.getRole().toString()){
                case "ADMIN":
                    System.out.println("Welcome"+ " "+username);
                    while(true){
System.out.println("------ADMIN MENU------");
System.out.println("1. Add Admin");
System.out.println("2. Delete Admin");
                        System.out.println("3. Fetch all admin");
                        System.out.println("4. Fetch Admin by ID");
                        System.out.println("5. Update Admin");
                        System.out.println("0. Exit");

                        int op= sc.nextInt();
                        switch(op){
                            case 1:
                                Admin admin = new Admin();

                                sc.nextLine();

                                System.out.println("Enter Admin Name:");
                                admin.setAdminName(sc.nextLine());

                                System.out.println("Enter Phone:");
                                admin.setPhone(sc.nextInt());

                                sc.nextLine();

                                System.out.println("Enter Position:");
                                admin.setPosition(sc.nextLine());

                                adminDao.insert(admin);

                                break;

                            case 2:
                                System.out.println("Enter ID to delete:");
                                int id = sc.nextInt();

                                adminDao.deleteById(id);

                                break;
                            case 3:
                                List<Admin> list = adminDao.getAllAdmins();

                                list.forEach(System.out::println);

                                break;
                            case 4:
                                System.out.println("Enter ID:");

                                id = sc.nextInt();

                                Admin adminById = adminDao.getAdminById(id);

                                System.out.println(adminById);

                                break;
                            case 5:

                                admin = new Admin();

                                System.out.println("Enter ID:");
                                admin.setId(sc.nextInt());

                                sc.nextLine();

                                System.out.println("Enter New Admin Name:");
                                admin.setAdminName(sc.nextLine());

                                System.out.println("Enter New Phone:");
                                admin.setPhone(sc.nextInt());

                                sc.nextLine();

                                System.out.println("Enter New Position:");
                                admin.setPosition(sc.nextLine());

                                adminDao.update(admin);

                                break;
                            case 0:
                                System.exit(0);

                            default:
                                System.out.println("Invalid Option");

                        }

                    }

                case "EMPLOYEE":
                    System.out.println("Welcome Employee"+user.getUsername());
                    break;
                default:
                    System.out.println("Invalid Role");
            }
        }catch(UserNotFoundException e){
            System.out.println(e.getMessage());

        }
        context.close();

    }
}
