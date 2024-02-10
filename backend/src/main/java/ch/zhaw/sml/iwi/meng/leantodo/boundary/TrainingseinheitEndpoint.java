package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Trainingseinheit;
import ch.zhaw.sml.iwi.meng.leantodo.service.TrainingseinheitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TrainingseinheitEndpoint {

    @Autowired
    private TrainingseinheitService trainingseinheitService;

    // Übung hinzufügen
    @PostMapping("/exercises")
    public String addExercise(@RequestBody Trainingseinheit trainingseinheit) {
        trainingseinheitService.addTrainingseinheit(trainingseinheit);
        return "Exercise successfully added.";
    }

    // Übung nach ID abrufen
    @GetMapping("/exercises/{id}")
    public Trainingseinheit getExerciseById(@PathVariable("id") Long id) {
        return trainingseinheitService.getTrainingseinheitById(id);
    }

    // Alle Übungen abrufen
    @GetMapping("/exercises")
    public List<Trainingseinheit> getAllExercises() {
        return trainingseinheitService.getAllTrainingseinheiten();
    }

    // Übung aktualisieren
    @PutMapping("/exercises/{id}")
    public Trainingseinheit updateExercise(@PathVariable("id") Long id, @RequestBody Trainingseinheit trainingseinheit) {
        trainingseinheit.setId(id);
        return trainingseinheitService.updateTrainingseinheit(trainingseinheit);
    }

    // Übung nach ID löschen
    @DeleteMapping("/exercises/{id}")
    public String deleteExercise(@PathVariable("id") Long id) {
        trainingseinheitService.deleteTrainingseinheit(id);
        return "Exercise deleted.";
    }
}
