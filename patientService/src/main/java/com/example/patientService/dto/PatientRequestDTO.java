package com.example.patientService.dto;

import java.time.LocalDate;
import com.example.patientservice.model.Patient;
import jakarta.validation.constraints.*;

public class PatientRequestDTO {
    @NotNull private LocalDate dob;
    @NotNull private LocalDate registerDate;
    @NotBlank private String name;
    @NotBlank @Email private String email;
    @NotBlank private String address;

    public Patient toPatient() {
        Patient p = new Patient();
        p.setName(name);
        p.setEmail(email);
        p.setAddress(address);
        p.setDob(dob);
        p.setRegisterDate(registerDate);
        return p;
    }

    // getters & setters
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public LocalDate getRegisterDate() { return registerDate; }
    public void setRegisterDate(LocalDate registerDate) { this.registerDate = registerDate; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}