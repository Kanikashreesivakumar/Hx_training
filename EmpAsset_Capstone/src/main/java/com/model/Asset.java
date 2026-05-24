package com.model;

import com.enums.AssetStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private LocalDate expireDate;
    private double assetValue;
    private LocalDate manufacturingDate;

    @Enumerated(EnumType.STRING)
    private AssetStatus status;
    @ManyToOne
    private AssetCategory category;


    public AssetStatus getStatus() {
        return status;
    }

    public void setStatus(AssetStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public double getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(double assetValue) {
        this.assetValue = assetValue;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public AssetCategory getCategory() {
        return category;
    }

    public void setCategory(AssetCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", expireDate=" + expireDate +
                ", assetValue=" + assetValue +
                ", manufacturingDate=" + manufacturingDate +
                ", status=" + status +
                ", category=" + category +
                '}';
    }
}
