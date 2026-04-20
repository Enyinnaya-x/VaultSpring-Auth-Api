package com.victor.auth_api.User;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import com.github.f4b6a3.uuid.UuidCreator;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)

    private UUID id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String role;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //required by hibernate
    public User(){

    }

    public User(UUID id, String name, String email, String password, String phone,
        String role, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

      // Generate ID automatically before saving
    @PrePersist
    public void generateId() {
        if (id == null) {
            id = UuidCreator.getTimeOrderedEpoch();
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    
    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }
    
    
    public Boolean getIsActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(UUID id) {
        this.id = id;
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
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
