package com.example.demo.yourapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "login_history")
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "users_name", length = 30)
    private String username;

    @Column(name = "login_time", nullable = false)
    private LocalDateTime loginTime;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private User user;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public LocalDateTime getLoginTime() { return loginTime; }
    public void setLoginTime(LocalDateTime loginTime) { this.loginTime = loginTime; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}