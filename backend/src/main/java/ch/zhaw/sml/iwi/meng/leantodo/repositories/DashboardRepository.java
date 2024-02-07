package ch.zhaw.sml.iwi.meng.leantodo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.zhaw.sml.iwi.meng.leantodo.dto.DashboardDTO;

@Repository
public interface DashboardRepository extends JpaRepository<DashboardDTO, Long>
{
   
}