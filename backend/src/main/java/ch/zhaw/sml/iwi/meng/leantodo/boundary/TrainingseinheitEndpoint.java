package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Trainingseinheit;
import ch.zhaw.sml.iwi.meng.leantodo.service.TrainingseinheitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TrainingseinheitEndpoint {

    @Autowired
    private TrainingseinheitService trainingseinheitService;

    // Übung hinzufügen
    @PostMapping("/trainingseinheit")
    public String addTrainingseinheit(@RequestBody Trainingseinheit trainingseinheit) {
        trainingseinheitService.addTrainingseinheit(trainingseinheit);
        return "Exercise successfully added.";
    }

    // Übung nach ID abrufen
    @GetMapping("/trainingseinheit/{id}")
    public Trainingseinheit getTrainingseinheitById(@PathVariable("id") Long id) {
        return trainingseinheitService.getTrainingseinheitById(id);
    }

    // Alle Übungen abrufen
    @GetMapping("/trainingseinheit")
    public List<Trainingseinheit> getAllTrainingseinheiten() {
        return trainingseinheitService.getAllTrainingseinheiten();
    }

    // Übung aktualisieren
    @PutMapping("/trainingseinheit/{id}")
    public Trainingseinheit updateTrainingseinheit(@PathVariable("id") Long id, @RequestBody Trainingseinheit trainingseinheit) {
        trainingseinheit.setId(id);
        return trainingseinheitService.updateTrainingseinheit(trainingseinheit);
    }

    // Übung nach ID löschen
    @DeleteMapping("/trainingseinheit/{id}")
    public String deleteTrainingseinheit(@PathVariable("id") Long id) {
        trainingseinheitService.deleteTrainingseinheit(id);
        return "Exercise deleted.";
    }

    // Gesamtpunktzahl speichern
    @PostMapping("/gesamtpunktzahl/{benutzerId}")
    public ResponseEntity<?> saveGesamtpunktzahl(@PathVariable Long benutzerId, @RequestBody Integer gesamtpunktzahl) {
        Integer gespeichertePunktzahl = trainingseinheitService.saveGesamtpunktzahl(benutzerId, gesamtpunktzahl);
        return ResponseEntity.ok(gespeichertePunktzahl);
    }

    // Gesamtpunktzahl abrufen
    @GetMapping("/gesamtpunktzahl/{benutzerId}")
    public ResponseEntity<?> getGesamtpunktzahl(@PathVariable Long benutzerId) {
        Integer punktzahl = trainingseinheitService.getGesamtpunktzahl(benutzerId);
        return ResponseEntity.ok(punktzahl);
    }

}
