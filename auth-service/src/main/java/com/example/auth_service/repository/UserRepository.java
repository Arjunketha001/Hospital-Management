package com.example.auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth_service.model.User;
import java.util.UUID;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByPatientId(UUID patientId);
}