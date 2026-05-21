package com.model;

import com.enums.IncidentStatus;
import com.enums.IncidentType;

public class Incident {

    private int id;
    private int officerId;
    private IncidentType incidentType;
    private String progressDetails;
    private IncidentStatus incidentStatus;


    public Incident(int id) {
        this.id = id;
    }


    public Incident(int officerId,
                    IncidentType incidentType,
                    String progressDetails,
                    IncidentStatus incidentStatus) {

        this.officerId = officerId;
        this.incidentType = incidentType;
        this.progressDetails = progressDetails;
        this.incidentStatus = incidentStatus;
    }


    public Incident() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
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
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", officerId=" + officerId +
                ", incidentType=" + incidentType +
                ", progressDetails='" + progressDetails + '\'' +
                ", incidentStatus=" + incidentStatus +
                '}';
    }
}