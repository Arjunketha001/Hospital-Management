package com.example.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.billingservice.model.BillingAccount;
import java.util.UUID;
import java.util.Optional;

public interface BillingAccountRepository extends JpaRepository<BillingAccount, UUID> {
    Optional<BillingAccount> findByPatientId(UUID patientId);
}