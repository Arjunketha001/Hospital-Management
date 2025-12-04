package com.example.PatientService.dto;

import java.time.LocalDate;

import com.example.PatientService.model.Patient;

public class PatientResponseDTO {

    private String id;
    private String name;
    private String email;
    private String address;
    private LocalDate dob;
    private LocalDate registeredDate;

    public PatientResponseDTO() {
    }

    public PatientResponseDTO(Patient patient) {
        this.id = patient.getId().toString();
        this.name = patient.getName();
        this.email = patient.getEmail();
        this.address = patient.getAddress();
        this.dob = patient.getDob();
        this.registeredDate = patient.getRegisterDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // 💡 CORRECTED: Capitalized D in Dob to follow Java Bean standards
    public LocalDate getDob() {
        return dob;
    }

    // 💡 CORRECTED: Capitalized D in Dob to follow Java Bean standards
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
}