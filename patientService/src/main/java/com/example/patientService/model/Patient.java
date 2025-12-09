package com.example.patientService.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Patient {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String address;

    @Column(unique = true)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "registered_date")
    private LocalDate registerDate;

    // getters & setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public LocalDate getRegisterDate() { return registerDate; }
    public void setRegisterDate(LocalDate registerDate) { this.registerDate = registerDate; }
}