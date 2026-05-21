package com.dao;

import com.exception.ResourceNotFoundException;
import com.model.Incident;

import java.util.List;

public interface IncidentDao {

    void insert(Incident incident);

    List<Incident> getAll();
    Incident getById(int id) throws ResourceNotFoundException;
    void deleteById(int id) throws ResourceNotFoundException;
    void update(int id, Incident incident)throws ResourceNotFoundException;

}
