package com.example.auth_service.dto;
public class PatientEvent {
    private String eventType;
    private PatientDto patient;
    public PatientEvent() {}
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public PatientDto getPatient() { return patient; }
    public void setPatient(PatientDto patient) { this.patient = patient; }
}