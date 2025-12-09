package com.example.patientService.dto;

import java.time.LocalDate;

import com.example.patientService.model.Patient;

public class PatientResponseDTO {
    private String id;
    private String name;
    private String email;
    private String address;
    private LocalDate dob;
    private LocalDate registeredDate;

    public PatientResponseDTO() {}
    public PatientResponseDTO(Patient p) {
        this.id = p.getId()==null?null:p.getId().toString();
        this.name = p.getName();
        this.email = p.getEmail();
        this.address = p.getAddress();
        this.dob = p.getDob();
        this.registeredDate = p.getRegisterDate();
    }
    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public LocalDate getRegisteredDate() { return registeredDate; }
    public void setRegisteredDate(LocalDate registeredDate) { this.registeredDate = registeredDate; }
}