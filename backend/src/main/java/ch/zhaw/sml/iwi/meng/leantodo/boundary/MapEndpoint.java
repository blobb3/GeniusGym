package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Map;
import ch.zhaw.sml.iwi.meng.leantodo.repositories.MapRepository;


@RestController
@CrossOrigin
public class MapEndpoint {

    @Autowired
    private MapRepository mapRepository;

    @GetMapping("/api/maps")
    public ResponseEntity<List<Map>> getAllMaps() {
        List<Map> maps = mapRepository.findAll();
        return new ResponseEntity<>(maps, HttpStatus.OK);
    }

    @PostMapping("/api/maps")
    public ResponseEntity<Map> createMap(@RequestBody @NonNull Map newMap) {
        Map savedMap = mapRepository.save(newMap);
        return new ResponseEntity<>(savedMap, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable @NonNull Long id) {
        return mapRepository.findById(id)
                .map(map -> {
                    mapRepository.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/api/route")
    public ResponseEntity<Map> saveMap(@RequestBody Map map) {
        Map route = new Map(map.getOrigin(), map.getDestination(), map.getDistance(), map.getDuration());
        Map savedRoute = mapRepository.save(route);
        return new ResponseEntity<>(savedRoute, HttpStatus.CREATED);
    }
    
}