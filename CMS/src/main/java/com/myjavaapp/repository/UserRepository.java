package com.myjavaapp.repository;

import com.myjavaapp.enums.IncidentStatus;
import com.myjavaapp.enums.IncidentType;
import com.myjavaapp.enums.Role;
import com.myjavaapp.exception.UserNotFoundException;
import com.myjavaapp.model.Incident;
import com.myjavaapp.model.Officer;
import com.myjavaapp.model.User;
import com.myjavaapp.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private final DBConnection dbConnection = new DBConnection();

    public User authenticateUser(String username, String password) throws SQLException {
        Connection connection = dbConnection.dbConnect();
        String sql = "select * from users where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet rst = preparedStatement.executeQuery();
        if(rst.next()){
            int id =  rst.getInt("id");
            String uname = rst.getString("username");
            String pass = rst.getString("password");
            Role role  = Role.valueOf(rst.getString("role").toUpperCase()) ;
            User user = new User(id,uname,pass,role);
            dbConnection.dbClose();
            return user;
        }
        else{
            dbConnection.dbClose();
            throw new UserNotFoundException("Wrong Credentials");
        }

    }

    public List<Incident> viewAllIncidents() throws SQLException {

        Connection connection = dbConnection.dbConnect();

        List<Incident> list = new ArrayList<>();

        String sql = "select * from incident";

        PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

        ResultSet rst = preparedStatement.executeQuery();

        while (rst.next()) {

            Officer officer = new Officer();
            officer.setId(rst.getInt("officer_id"));

            Incident incident = new Incident(
                    rst.getInt("id"),
                    IncidentType.valueOf(
                            rst.getString("type")
                                    .toUpperCase()
                                    .replace(" ", "_")
                                    .replace("REPORT_", "")
                    ),
                    rst.getString("progress_details"),
                    IncidentStatus.valueOf(rst.getString("status")
                            .toUpperCase()
                            .replace(" ", "_")
                            .replace("REPORT_", "")
                    )
            );

            incident.setOfficer(officer);
            list.add(incident);
        }
        dbConnection.dbClose();
        return list;
    }

    public List<Incident> filterByStatus(IncidentStatus incidentStatus)throws SQLException {
        Connection connection = dbConnection.dbConnect();

        List<Incident> list = new ArrayList<>();

        String sql = "select * from incident";

        PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

        ResultSet rst = preparedStatement.executeQuery();

        while (rst.next()) {

            Officer officer = new Officer();
            officer.setId(rst.getInt("officer_id"));

            Incident incident = new Incident(
                    rst.getInt("id"),
                    IncidentType.valueOf(
                            rst.getString("type")
                                    .toUpperCase()
                                    .replace(" ", "_")
                                    .replace("REPORT_", "")
                    ),
                    rst.getString("progress_details"),
                    IncidentStatus.valueOf(rst.getString("status")
                            .toUpperCase()
                            .replace(" ", "_")
                            .replace("REPORT_", "")
                    )
            );

            incident.setOfficer(officer);
            list.add(incident);

        }
        dbConnection.dbClose();
        return list.stream()
                .filter(i -> i.getIncidentStatus().equals(incidentStatus))
                .collect(Collectors.toList());
    }

    public Incident insertIncident(Incident newIncident,String username) throws SQLException, UserNotFoundException {
        Connection connection = dbConnection.dbConnect();
        String sql = "select * from officer where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet rst = preparedStatement.executeQuery();

        int officerId;
        String userRole;

        if (rst.next()) {
            officerId = rst.getInt("id");
            String insertSql = "insert into incident (type, progress_details, status, officer_id) values (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertSql);
            ps.setString(1, newIncident.getIncidentType().name());
            ps.setString(2, newIncident.getProgressDetails());
            ps.setString(3, newIncident.getIncidentStatus().name());
            ps.setInt(4, officerId);
            ps.executeUpdate();

        } else {
            throw new UserNotFoundException("Invalid User Account");
        }

        dbConnection.dbClose();
        return newIncident;
    }
}