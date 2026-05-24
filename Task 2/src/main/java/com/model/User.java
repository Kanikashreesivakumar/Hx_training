package com.model;

import com.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int is;
    @Column(nullable = false,unique = true)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public int getIs() {
        return is;
    }

    public void setIs(int is) {
        this.is = is;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "is=" + is +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
