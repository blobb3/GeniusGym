package ch.zhaw.sml.iwi.meng.leantodo.service;


import ch.zhaw.sml.iwi.meng.leantodo.entity.Trainingseinheit;
import ch.zhaw.sml.iwi.meng.leantodo.repositories.TrainingseinheitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingseinheitServiceImpl implements TrainingseinheitService {

    @Autowired
    private TrainingseinheitRepository trainingseinheitRepository;

    @SuppressWarnings("null")
    @Override
    public Trainingseinheit addTrainingseinheit(Trainingseinheit trainingseinheit) {
        return trainingseinheitRepository.save(trainingseinheit);
    }

    @Override
    public Trainingseinheit getTrainingseinheitById(Long id) {
        Optional<Trainingseinheit> trainingseinheit = trainingseinheitRepository.findById(id);
        return trainingseinheit.orElse(null);
    }

    @Override
    public List<Trainingseinheit> getAllTrainingseinheiten() {
        return trainingseinheitRepository.findAll();
    }

    @Override
    public void deleteTrainingseinheit(Long id) {
        trainingseinheitRepository.deleteById(id);
    }

    @Override
    public Trainingseinheit updateTrainingseinheit(Trainingseinheit trainingseinheit) {
        // Bevor Sie aktualisieren, prüfen Sie, ob die Trainingseinheit bereits existiert
        if(trainingseinheit.getId() != null && trainingseinheitRepository.existsById(trainingseinheit.getId())) {
            return trainingseinheitRepository.save(trainingseinheit);
        }
        return null; // oder eine angemessene Handhabung, wenn die Trainingseinheit nicht existiert
    }
}
