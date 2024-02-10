package ch.zhaw.sml.iwi.meng.leantodo.service;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Trainingseinheit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainingseinheitService {
    Trainingseinheit addTrainingseinheit(Trainingseinheit trainingseinheit);

    Trainingseinheit getTrainingseinheitById(Long id);

    List<Trainingseinheit> getAllTrainingseinheiten();

    void deleteTrainingseinheit(Long id);

    Trainingseinheit updateTrainingseinheit(Trainingseinheit trainingseinheit);

    Integer saveGesamtpunktzahl(Integer gesamtpunktzahl);

    Integer getGesamtpunktzahl();
}
