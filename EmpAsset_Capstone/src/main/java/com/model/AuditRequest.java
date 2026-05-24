package com.model;

import com.enums.AuditStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="audit_request")
public class AuditRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private LocalDate auditDate;
    @Enumerated(EnumType.STRING)
    private AuditStatus auditStatus;
    private String remarks;
    @ManyToOne
    private Admin admin;
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

    public LocalDate getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(LocalDate auditDate) {
        this.auditDate = auditDate;
    }

    public AuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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
        return "AuditRequest{" +
                "id=" + id +
                ", auditDate=" + auditDate +
                ", auditStatus=" + auditStatus +
                ", remarks='" + remarks + '\'' +
                ", admin=" + admin +
                ", employee=" + employee +
                ", asset=" + asset +
                '}';
    }
}
