package com.example.PatientService.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.PatientService.dto.PatientRequestDTO;
import com.example.PatientService.dto.PatientResponseDTO;
import com.example.PatientService.exception.EmailAlreadyExistsException;
import com.example.PatientService.exception.PatientNotFoundException;
import com.example.PatientService.model.Patient;
import com.example.PatientService.repository.PatientRepository;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients=patientRepository.findAll();

        List<PatientResponseDTO> patientResponseDTOs=patients.stream().map(patient->  new PatientResponseDTO(patient)).toList();

        return patientResponseDTOs;   
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
             throw new EmailAlreadyExistsException(
                            "A patient with this email " + "already exists"
              + patientRequestDTO.getEmail());
    }

        Patient newPatient=patientRepository.save(patientRequestDTO.toPatient()) ;

        return new PatientResponseDTO(newPatient);
    }

    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO) {

        Patient patient = patientRepository.findById(id).orElseThrow(
            () -> new PatientNotFoundException("Patient not found with ID: " + id));

        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),
            id)) {
        throw new EmailAlreadyExistsException(
            "A patient with this email " + "already exists"
                + patientRequestDTO.getEmail());
        }

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDob(patientRequestDTO.getDob());

        Patient updatedPatient = patientRepository.save(patient);


        return new PatientResponseDTO(updatedPatient);
    }

        public void deletePatient(UUID id) {
            patientRepository.deleteById(id);
        }


    
}
