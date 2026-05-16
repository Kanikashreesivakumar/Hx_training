package com.myjavaapp.repository;

import com.myjavaapp.model.Customer;
import com.myjavaapp.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    DBConnection dbConnection = new DBConnection();



    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        Connection connection =  dbConnection.dbConnect();
        // Call the proc and fetch the resultset
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL get_all_customers()}");
            ResultSet rst = callableStatement.executeQuery();

            while(rst.next()){
                int id = rst.getInt("id");
                String name = rst.getString("name");
                String city = rst.getString("city");
                int age = rst.getInt("age");
                Customer customer = new Customer(id,name,city,age); //100X 200X 300X
                list.add(customer); //100X 200X 300X
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        dbConnection.dbClose();
        return list;
    }

    public List<Customer> getCustomersByCity(String city) throws SQLException {
        List<Customer> list = new ArrayList<>();
        Connection connection =  dbConnection.dbConnect();
        // Call the proc and fetch the resultset

        CallableStatement callableStatement = connection.prepareCall("{CALL get_customers_by_city(?)}");

        callableStatement.setString(1,city);

        ResultSet rst = callableStatement.executeQuery();

        while(rst.next()){
            int id = rst.getInt("id");
            String name = rst.getString("name");
            String cityDb = rst.getString("city");
            int age = rst.getInt("age");
            Customer customer = new Customer(id,name,cityDb,age); //100X 200X 300X
            list.add(customer); //100X 200X 300X
        }

        dbConnection.dbClose();
        return list;
    }

    public List<Customer> getAllCustomerView() {
        List<Customer> list = new ArrayList<>();
        Connection connection =  dbConnection.dbConnect();
        // Call the proc and fetch the resultset
        try {
            PreparedStatement preparedStatement =  connection.prepareStatement("select * from customer_view");
            //CallableStatement callableStatement = connection.prepareCall("{CALL get_all_customers()}");
            ResultSet rst = preparedStatement.executeQuery();

            while(rst.next()){
                int id = rst.getInt("id");
                String name = rst.getString("name");
                String city = rst.getString("city");

                Customer customer = new Customer(id,name,city); //100X 200X 300X
                list.add(customer); //100X 200X 300X
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        dbConnection.dbClose();
        return list;
    }
}