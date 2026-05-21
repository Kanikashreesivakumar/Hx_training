package com.dao_impl;

import com.dao.IncidentDao;
import com.exception.ResourceNotFoundException;
import com.model.Incident;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncidentDaoImpl implements IncidentDao {
    private final JdbcTemplate jdbcTemplate;
    public IncidentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Incident incident) {
                    String sql="insert into incident(officer_id,type,progress_details,status) "+"values(?,?,?,?)";
                    jdbcTemplate.update(sql,
                            incident.getOfficerId(),
                            incident.getIncidentType().toString(),
                            incident.getProgressDetails(),
                            incident.getIncidentStatus().toString());
                    System.out.println("Incident Added.");

    }

    @Override
    public List<Incident> getAll() {
        return List.of();
    }

    @Override
    public Incident getById(int id) throws ResourceNotFoundException {
        return null;
    }



    @Override
    public void deleteById(int id) throws ResourceNotFoundException {
        String sql ="delete from incident where id =? ";
        int numRow = jdbcTemplate.update(sql, id);
        if(numRow == 0)
            throw new ResourceNotFoundException("Invalid id");

        System.out.println("incident deleted");
    }

    @Override
    public void update(int id, Incident incident) throws ResourceNotFoundException {

    }
}