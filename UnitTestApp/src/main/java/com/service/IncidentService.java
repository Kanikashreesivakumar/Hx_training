package com.service;

import com.Exception.ResourceNotFoundException;
import com.enums.IncidentStatus;
import com.enums.IncidentType;
import com.model.Incident;

import java.util.List;
import java.util.stream.Collectors;

public class IncidentService {

    public Incident getById(List<Incident> list, int id) {

        return list
                .stream()
                .filter(incident -> incident.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Invalid id given!!."));
    }

    public List<Incident> getByStatus(List<Incident> list, IncidentStatus status) {

        return list
                .stream()
                .filter(incident -> incident.getIncidentStatus().equals(status))
                .toList();
    }

    public List<Incident> getByType(List<Incident> list, IncidentType type) {

        return list
                .stream()
                .filter(incident -> incident.getIncidentType().equals(type))
                .toList();
    }
}