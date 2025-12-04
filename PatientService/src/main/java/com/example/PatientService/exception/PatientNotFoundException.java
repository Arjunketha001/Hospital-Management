package com.example.PatientService.exception;

public class PatientNotFoundException extends RuntimeException{
  public PatientNotFoundException(String message) {
    super(message);
  }

}
