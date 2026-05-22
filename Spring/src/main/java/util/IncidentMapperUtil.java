package com.util;

import com.enums.IncidentStatus;
import com.enums.IncidentType;
import com.model.Incident;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class IncidentMapperUtil implements RowMapper<Incident> {

    @Override
    public Incident mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Incident(
                rs.getInt("id"),
                IncidentType.valueOf(rs.getString("type")),
                rs.getString("details"),
                IncidentStatus.valueOf(rs.getString("status"))
        );
    }
}