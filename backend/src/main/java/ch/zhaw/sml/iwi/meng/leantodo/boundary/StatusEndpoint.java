package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Status;
import ch.zhaw.sml.iwi.meng.leantodo.repositories.StatusRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Level;

@RestController
@RequestMapping("/api/status")
@CrossOrigin
public class StatusEndpoint {

    @Autowired
    private StatusRepository statusRepository;

    @PostMapping
    public Status saveOrUpdateStatus(@RequestBody Status status) {
        if (status.getPunkte() != null) {
            // Verwenden der calculateLevel Methode des Enums zur Bestimmung des Levels
            status.setLevel(Level.calculateLevel(status.getPunkte()));
        }
        return statusRepository.save(status);
    }
    
    @SuppressWarnings("null")
    @GetMapping("/{id}")
    public Status getStatus(@PathVariable Long id) {
        return statusRepository.findById(id).orElse(null);
    }
}
