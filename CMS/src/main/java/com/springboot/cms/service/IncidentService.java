package com.springboot.cms.service;

import com.springboot.cms.exception.ResourceNotFoundException;
import com.springboot.cms.model.Incident;
import com.springboot.cms.repository.IncidentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IncidentService
{
    private final IncidentRepository incidentRepository;
    public List<Incident> getAll() {
        return incidentRepository.findAll();
    }

    public void addIncident(Incident incident) {
        incidentRepository.save(incident);
    }


    public Incident getById(int id) {
        return incidentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Invalid incident id"));
    }
    public void deleteById(int id) {
        getById(id); // validation
        incidentRepository.deleteById(id);
    }

    public void update(int id, Incident updatedIncident) {
        Incident exisitngIncident = getById(id);

        exisitngIncident.setIncidentStatus(updatedIncident.getIncidentStatus());
        exisitngIncident.setIncidentType(updatedIncident.getIncidentType());
        exisitngIncident.setProgressDetails(updatedIncident.getProgressDetails());
        incidentRepository.save(exisitngIncident);
    }
}
