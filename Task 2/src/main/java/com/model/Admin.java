package com.model;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.User;

@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable =false)
    private String adminName;
    private int phone;
    private String position;
    @OneToOne
    private User user;

    public Admin(int id, String adminName, int phone, String position, User user) {
        this.id = id;
        this.adminName = adminName;
        this.phone = phone;
        this.position = position;
        this.user = user;
    }

    public Admin(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", phone=" + phone +
                ", position='" + position + '\'' +
                ", user=" + user +
                '}';
    }
}
