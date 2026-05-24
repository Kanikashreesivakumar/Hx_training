package com.model;

import com.enums.RequestStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="asset_request")
public class AssetRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private LocalDate requestDate;
    private String reason;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private AssetCategory category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AssetCategory getCategory() {
        return category;
    }

    public void setCategory(AssetCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "AssetRequest{" +
                "id=" + id +
                ", requestDate=" + requestDate +
                ", reason='" + reason + '\'' +
                ", requestStatus=" + requestStatus +
                ", employee=" + employee +
                ", category=" + category +
                '}';
    }
}
