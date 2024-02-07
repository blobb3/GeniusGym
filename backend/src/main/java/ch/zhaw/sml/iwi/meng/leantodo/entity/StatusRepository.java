package ch.zhaw.sml.iwi.meng.leantodo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Project, Long>
{
    public List<Project> findByOwner(String owner);

    // soll Status Objekt in DB speihern
    public void save(Status status);
}