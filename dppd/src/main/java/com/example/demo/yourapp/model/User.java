package com.example.demo.yourapp.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "users_login")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long id;

    @Column(name = "users_name", unique = true, nullable = false, length = 30)
    private String username;

    @Column(name = "password_hash", nullable = false length = 20)
    private String password;

    @Column(name = "users_email", nullable = true length = 55)
    private String email;

    public User(String username, String password, String email, LocalDateTime loginTime) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<LoginHistory> getLoginHistories() { return loginHistories; }
    public void setLoginHistories(List<LoginHistory> loginHistories) { this.loginHistories = loginHistories; }
}
