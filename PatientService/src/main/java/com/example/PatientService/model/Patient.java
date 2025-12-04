package com.example.PatientService.model;

import java.time.LocalDate;
import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @NotNull
    private String name;
    
    @NotNull
    private String address;
    
    @Email
    @NotNull
    @Column(unique=true)
    private String email;

    @NotNull
    // 💡 Fix 1: Map the 'dob' field to the 'date_of_birth' column
    @Column(name = "date_of_birth") 
    private LocalDate dob;
    
    @NotNull
    // 💡 Fix 2: Map the 'registerDate' field to the 'registered_date' column
    @Column(name = "registered_date")
    private LocalDate registerDate;

    // --- Getters and Setters (Updated to reflect mapping) ---

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }
}