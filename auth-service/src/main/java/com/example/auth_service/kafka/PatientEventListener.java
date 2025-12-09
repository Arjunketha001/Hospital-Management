package main.java.com.example.auth_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.auth.repository.UserRepository;
import com.example.auth.model.User;
import com.example.auth.dto.PatientEvent;
import com.example.auth.dto.PatientDto;
import java.util.UUID;

@Component
public class PatientEventListener {
    private final UserRepository repo;
    public PatientEventListener(UserRepository repo) { this.repo = repo; }

    @KafkaListener(topics = "patient.events", groupId = "auth-group")
    public void onMessage(PatientEvent ev) {
        if (ev == null || ev.getEventType() == null) return;
        if ("patient.created".equals(ev.getEventType())) {
            PatientDto p = ev.getPatient();
            UUID pid = UUID.fromString(p.getId());
            repo.findByPatientId(pid).orElseGet(() -> {
                User u = new User();
                u.setPatientId(pid);
                u.setUsername(p.getEmail());
                u.setPasswordHash("changeme"); // dev only
                return repo.save(u);
            });
        }
    }
}