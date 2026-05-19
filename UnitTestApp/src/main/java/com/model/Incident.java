package com.model;

import com.enums.IncidentStatus;
import com.enums.IncidentType;

import java.util.Objects;

public class Incident {

    private int id;
    private IncidentType incidentType;
    private String progressDetails;
    private IncidentStatus incidentStatus;

    public Incident(){}

    public Incident(int id, IncidentType incidentType, String progressDetails, IncidentStatus incidentStatus) {
        this.id = id;
        this.incidentType = incidentType;
        this.progressDetails = progressDetails;
        this.incidentStatus = incidentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IncidentType getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentType incidentType) {
        this.incidentType = incidentType;
    }

    public String getProgressDetails() {
        return progressDetails;
    }

    public void setProgressDetails(String progressDetails) {
        this.progressDetails = progressDetails;
    }

    public IncidentStatus getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(IncidentStatus incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Incident incident)) return false;
        return id == incident.id && incidentType == incident.incidentType && Objects.equals(progressDetails, incident.progressDetails) && incidentStatus == incident.incidentStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, incidentType, progressDetails, incidentStatus);
    }
}
