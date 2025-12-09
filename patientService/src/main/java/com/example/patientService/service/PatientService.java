package com.example.patientService.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import com.example.patientService.repository.PatientRepository;
import com.example.patientService.dto.*;
import com.example.patientService.model.Patient;
import com.example.patientService.kafka.KafkaPublisher;
import com.example.patientService.kafka.PatientEvent;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final KafkaPublisher kafkaPublisher;

    public PatientService(PatientRepository patientRepository, KafkaPublisher kafkaPublisher) {
        this.patientRepository = patientRepository;
        this.kafkaPublisher = kafkaPublisher;
    }

    public List<PatientResponseDTO> getPatients() {
        return patientRepository.findAll().stream().map(PatientResponseDTO::new).toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO dto) {
        if (patientRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists: " + dto.getEmail());
        }
        Patient saved = patientRepository.save(dto.toPatient());
        PatientEvent ev = new PatientEvent("patient.created", saved);
        kafkaPublisher.publish("patient.events", saved.getId().toString(), ev);
        return new PatientResponseDTO(saved);
    }

    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO dto) {
        Patient p = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        if (patientRepository.existsByEmailAndIdNot(dto.getEmail(), id)) throw new RuntimeException("Email exists");
        p.setName(dto.getName()); p.setAddress(dto.getAddress()); p.setEmail(dto.getEmail()); p.setDob(dto.getDob());
        Patient updated = patientRepository.save(p);
        PatientEvent ev = new PatientEvent("patient.updated", updated);
        kafkaPublisher.publish("patient.events", updated.getId().toString(), ev);
        return new PatientResponseDTO(updated);
    }

    public void deletePatient(UUID id) { patientRepository.deleteById(id); }
}