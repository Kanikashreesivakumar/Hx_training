package com.repository;

import com.model.Customer;
import com.util.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;


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


    public  int getTotalCustomersByCity(String city){
        Connection connection=dbConnection.dbConnect();

        int tot=0;
        try{
            CallableStatement callableStatement = connection.prepareCall("{CALL get_customer_count_by_city(?,?)}");
            callableStatement.setString(1,city);
            callableStatement.registerOutParameter(2,Types.INTEGER);
            callableStatement.execute();
            tot=callableStatement.getInt(2);
        }

        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        dbConnection.dbClose();
        return tot;
    }
}