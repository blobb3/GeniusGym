package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import ch.zhaw.sml.iwi.meng.leantodo.dto.DashboardDTO;
import ch.zhaw.sml.iwi.meng.leantodo.repositories.DashboardRepository;

@RestController
@CrossOrigin
public class DashboardEndpoint {

    @Autowired
    private DashboardRepository dashboardRepository;

    @GetMapping("/dashboards")
    public List<DashboardDTO> fetchDashboard() {
        return dashboardRepository.findAll();
    }

    @PostMapping("/dashboards")
    @ResponseStatus(HttpStatus.CREATED)
    public DashboardDTO createDashboard(@RequestBody @NonNull DashboardDTO dashboard) {
        return dashboardRepository.save(dashboard);
    }

    @DeleteMapping("/dashboards/{id}")
    public ResponseEntity<Void> deleteDashboard(@PathVariable @NonNull Long id) {
        if (dashboardRepository.existsById(id)) {
            dashboardRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
