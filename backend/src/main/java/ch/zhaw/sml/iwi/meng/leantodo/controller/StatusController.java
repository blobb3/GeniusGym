package ch.zhaw.sml.iwi.meng.leantodo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Status;
import ch.zhaw.sml.iwi.meng.leantodo.entity.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin // Erlaubt CORS-Anfragen von allen Quellen
@RestController
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @PostMapping("/status")
    public void saveUserStatus(@RequestBody Status status) {
        statusRepository.save(status);
    }
}
