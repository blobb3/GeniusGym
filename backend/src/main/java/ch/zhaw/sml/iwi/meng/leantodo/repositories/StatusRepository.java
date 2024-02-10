package ch.zhaw.sml.iwi.meng.leantodo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
   

}
