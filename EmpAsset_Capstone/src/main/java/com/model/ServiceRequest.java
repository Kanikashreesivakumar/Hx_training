package com.model;

import com.enums.ServiceStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="Service_request")
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(nullable = false)
    private String issue;
    private String description;
    private LocalDate requestDate;
    @Enumerated(EnumType.STRING)
    private ServiceStatus status;

    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Asset asset;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "id=" + id +
                ", issue='" + issue + '\'' +
                ", description='" + description + '\'' +
                ", requestDate=" + requestDate +
                ", status=" + status +
                ", employee=" + employee +
                ", asset=" + asset +
                '}';
    }
}
