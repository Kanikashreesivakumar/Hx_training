package com.myjavaapp.model;

import com.myjavaapp.enums.IncidentStatus;
import com.myjavaapp.enums.IncidentType;

import java.util.Objects;

public class Incident extends  Object{
    private int id;
    private IncidentType incidentType;
    private String progressDetails;
    private IncidentStatus incidentStatus;

    private Officer officer; //Officer injected in Incident
    // private int officer_id; //<-- wrong..


    public Incident() {
    }

    public Incident(int id, IncidentType incidentType, String progressDetails, IncidentStatus incidentStatus ) {
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

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", incidentType=" + incidentType +
                ", progressDetails='" + progressDetails + '\'' +
                ", incidentStatus=" + incidentStatus +
                ", officer=" + officer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Incident incident = (Incident) o;
        return id == incident.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}