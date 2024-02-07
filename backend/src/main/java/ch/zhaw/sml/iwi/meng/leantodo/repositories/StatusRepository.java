package ch.zhaw.sml.iwi.meng.leantodo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    @Query("SELECT s FROM User u INNER JOIN u.history s WHERE u.loginName = ?1 ORDER BY s.datum DESC LIMIT 1")
    public Status getLatestStatusByLoginName(String loginName);

}
