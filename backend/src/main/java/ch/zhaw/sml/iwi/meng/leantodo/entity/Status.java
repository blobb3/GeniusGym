package ch.zhaw.sml.iwi.meng.leantodo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Constructor & Getter
@NoArgsConstructor
@Getter
@Setter

@Entity
@Data
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long groesse;

    private Long gewicht;

    private Float bmi;

    private String owner;

    private String name;

    private Long level;

    private Long points;

    private Long pointsToNextLevel;

    @OneToMany
    private List<ToDo> toDos = new ArrayList<>();
    
}