package com.example.billingservice.model;
import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "billing_account", schema = "billing_service")
public class BillingAccount {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable=false, unique=true)
    private UUID patientId;
    private String patientName;
    private double balance = 0.0;
    private LocalDateTime createdAt = LocalDateTime.now();

    // getters & setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getPatientId() { return patientId; }
    public void setPatientId(UUID patientId) { this.patientId = patientId; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}