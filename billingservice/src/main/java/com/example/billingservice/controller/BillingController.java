package main.java.com.example.billingservice.controller;

import org.springframework.web.bind.annotation.*;
import com.example.billing.repository.BillingAccountRepository;
import com.example.billing.model.BillingAccount;
import java.util.UUID;

@RestController
@RequestMapping("/billing")
public class BillingController {
    private final BillingAccountRepository repo;
    public BillingController(BillingAccountRepository repo) { this.repo = repo; }

    @GetMapping("/by-patient/{patientId}")
    public BillingAccount getByPatient(@PathVariable String patientId) {
        return repo.findByPatientId(UUID.fromString(patientId)).orElse(null);
    }
}