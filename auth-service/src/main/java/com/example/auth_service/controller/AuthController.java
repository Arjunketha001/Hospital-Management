package main.java.com.example.auth_service.controller;

import org.springframework.web.bind.annotation.*;
import com.example.auth.repository.UserRepository;
import com.example.auth.model.User;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository repo;
    public AuthController(UserRepository repo) { this.repo = repo; }

    @GetMapping("/by-patient/{patientId}")
    public User getByPatient(@PathVariable String patientId) {
        return repo.findByPatientId(UUID.fromString(patientId)).orElse(null);
    }
}