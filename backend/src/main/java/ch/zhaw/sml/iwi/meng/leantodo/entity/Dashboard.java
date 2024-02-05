package ch.zhaw.sml.iwi.meng.leantodo.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long levelanzeige;

    private Time mappergebnis;

    private Long uebungsergebnis;

    @OneToMany
    private List<ToDo> toDos = new ArrayList<>();

    
}