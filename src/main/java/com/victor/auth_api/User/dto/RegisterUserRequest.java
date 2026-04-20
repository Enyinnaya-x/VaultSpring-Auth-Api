package com.victor.auth_api.User.dto;

import jakarta.validation.constraints.*;

public class RegisterUserRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    @Size(min = 8)
    private String confirmPassword;

    @NotBlank
    @Size(min = 11)
    private String phone;


    // getters & setters
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    
    
    public String getPhone() {
        return phone;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
