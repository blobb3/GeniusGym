package ch.zhaw.sml.iwi.meng.leantodo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingseinheitRepository extends JpaRepository<ToDo,Long> {
    public List<ToDo> findByOwner(String owner);
   
    @Query("SELECT t FROM ToDo as t WHERE t.owner = ?1")
    public List<ToDo> findAllButArchivedByOwner(String owner);
    
}