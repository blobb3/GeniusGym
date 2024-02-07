package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.security.Principal;
import org.springframework.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.sml.iwi.meng.leantodo.controller.StatusController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Status;
import ch.zhaw.sml.iwi.meng.leantodo.repositories.StatusRepository;

@RestController
public class StatusEndpoint {

    @Autowired
    private StatusController statusController;

    @Autowired
    private StatusRepository statusRepository; // Hinzufügen dieser Zeile

    @GetMapping("/api/status/current")
    public Status getCurrentStatus(Principal principal) {
        return statusController.getLatestStatus(principal.getName());
    }

    @PostMapping("/status")
    public void saveUserStatus(@RequestBody @NonNull Status status) {
        statusRepository.save(status);
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable @NonNull Long id) {
        return statusRepository.findById(id)
                .map(status -> {
                    statusRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
