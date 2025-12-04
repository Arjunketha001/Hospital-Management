package com.example.PatientService.dto;

import java.time.LocalDate;

import com.example.PatientService.model.Patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    public PatientRequestDTO() {
    }

    @NotNull(message = "Date of birth is required")
    private LocalDate dob;

    @NotNull(message = "Registered date is required")
    private LocalDate registerDate;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    public Patient toPatient() {
        Patient patient = new Patient();
        patient.setName(getName());
        patient.setEmail(getEmail());
        patient.setAddress(getAddress());
        patient.setDob(getDob());
        patient.setRegisterDate(getRegisterDate());
        return patient;
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
}
