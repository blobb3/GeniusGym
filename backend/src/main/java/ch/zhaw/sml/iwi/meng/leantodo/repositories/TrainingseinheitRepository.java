package ch.zhaw.sml.iwi.meng.leantodo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Trainingseinheit;

@Repository
public interface TrainingseinheitRepository extends JpaRepository<Trainingseinheit,Long> {

    
}