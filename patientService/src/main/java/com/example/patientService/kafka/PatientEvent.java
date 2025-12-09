package com.example.patientService.kafka;

import com.example.patientService.model.Patient;

public class PatientEvent {
    private String eventType;
    private Patient patient;
    public PatientEvent() {}
    public PatientEvent(String eventType, Patient patient) { this.eventType = eventType; this.patient = patient; }
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
}