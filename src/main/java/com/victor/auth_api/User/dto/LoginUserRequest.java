package com.victor.auth_api.User.dto;
import jakarta.validation.constraints.*;


public class LoginUserRequest {
    @Email
    @NotBlank
    private String email;

    @Size(min = 8)
    private String password;

    // getters and setters
    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
