package com.validate.springvalidation.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.AssertTrue;

public class LoginatData {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    private String email;

    @AssertTrue(message = "You must agree to the terms.")
    private boolean agreed; // Replace `acceptTerms` if this is the intended field name

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAgreed() { // Getter for boolean property
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    @Override
    public String toString() {
        return "LoginatData{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", agreed=" + agreed +
                '}';
    }
}
