package com.model;

import jakarta.persistence.*;
@Entity
public class Admin {
         @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
         @Column(nullable = false)
    private String adminName;
         private String position;
         private int phone;

         @OneToOne
    private User user;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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
                ", position='" + position + '\'' +
                ", phone=" + phone +
                ", user=" + user +
                '}';
    }
}
