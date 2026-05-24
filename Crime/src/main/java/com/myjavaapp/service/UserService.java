package com.myjavaapp.service;

import com.myjavaapp.enums.IncidentStatus;
import com.myjavaapp.enums.IncidentType;
import com.myjavaapp.model.Incident;
import com.myjavaapp.model.User;
import com.myjavaapp.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User authenticateUser(String username, String password) throws SQLException {
        return userRepository.authenticateUser(username,password);
    }

    public List<Incident> viewAlIncidents() throws SQLException {
        return userRepository.viewAllIncidents();
    }

    public List<Incident> filterByStatus(IncidentStatus incidentStatus) throws SQLException {
        return userRepository.filterByStatus(incidentStatus);
    }
    public Incident insertIncident(Incident newIncident, String username) throws SQLException {
        return userRepository.insertIncident(newIncident,username);
    }
}