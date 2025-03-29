package com.example.arch_template.domain.model;

import lombok.Data;

@Data
public class UserData {

    private String email;
    private String name;

    public UserData(String email, String name) {
        this.setEmail(email);
        this.name = name;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    private boolean isValidEmail(String email) {
        // Simple email validation logic
        // In a real-world application, you might want to use a more robust regex
        return email.contains("@");
    }
}
