package com.example.demo.yourapp.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "نام کاربری نمی‌تواند خالی باشد!")
    private String username;

    @NotBlank(message = "رمز عبور نمی‌تواند خالی باشد!")
    private String password;

    // Getters and Setters
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
}
