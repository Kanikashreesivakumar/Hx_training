package com;

import com.config.AppConfig;
import com.dao.AdminDao;
import com.model.Admin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AdminDao adminDao = context.getBean(AdminDao.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n----- ADMIN CRUD -----");

            System.out.println("1. Add Admin");
            System.out.println("2. Delete Admin");
            System.out.println("3. Fetch All Admin");
            System.out.println("4. Fetch Admin By ID");
            System.out.println("5. Update Admin");
            System.out.println("0. Exit");

            int op = sc.nextInt();

            switch (op) {

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

                    System.out.println("Invalid option");
            }
        }
    }
}