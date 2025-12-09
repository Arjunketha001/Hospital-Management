package com.example.billingservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.billingservice.dto.PatientEvent;
import com.example.billingservice.dto.PatientDto;
import com.example.billingservice.model.BillingAccount;
import com.example.billingservice.repository.BillingAccountRepository;
import java.util.UUID;

@Component
public class PatientEventListener {
    private final BillingAccountRepository repo;
    public PatientEventListener(BillingAccountRepository repo) { this.repo = repo; }

    @KafkaListener(topics = "patient.events", groupId = "billing-group")
    public void onMessage(PatientEvent ev) {
        if (ev == null || ev.getEventType() == null) return;
        if ("patient.created".equals(ev.getEventType())) {
            PatientDto p = ev.getPatient();
            UUID pid = UUID.fromString(p.getId());
            repo.findByPatientId(pid).orElseGet(() -> {
                BillingAccount b = new BillingAccount();
                b.setPatientId(pid);
                b.setPatientName(p.getName());
                b.setBalance(0.0);
                return repo.save(b);
            });
        } else if ("patient.updated".equals(ev.getEventType())) {
            PatientDto p = ev.getPatient();
            UUID pid = UUID.fromString(p.getId());
            repo.findByPatientId(pid).ifPresent(b -> { b.setPatientName(p.getName()); repo.save(b); });
        }
    }
}