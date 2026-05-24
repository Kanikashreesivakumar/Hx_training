package com.model;

import com.enums.AllocationStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="asset_allocation")
public class AssetAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private LocalDate allocatedDate;
    private LocalDate returnDate;
    @Enumerated(EnumType.STRING)
    private AllocationStatus status;
    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Asset asset;

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AllocationStatus getStatus() {
        return status;
    }

    public void setStatus(AllocationStatus status) {
        this.status = status;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getAllocatedDate() {
        return allocatedDate;
    }

    public void setAllocatedDate(LocalDate allocatedDate) {
        this.allocatedDate = allocatedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AssetAllocation{" +
                "id=" + id +
                ", allocatedDate=" + allocatedDate +
                ", returnDate=" + returnDate +
                ", status=" + status +
                ", employee=" + employee +
                ", asset=" + asset +
                '}';
    }
}
