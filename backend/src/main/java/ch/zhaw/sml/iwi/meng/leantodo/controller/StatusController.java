package ch.zhaw.sml.iwi.meng.leantodo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Status;
import ch.zhaw.sml.iwi.meng.leantodo.repositories.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@CrossOrigin // Erlaubt CORS-Anfragen von allen Quellen
@Component
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    public Status getLatestStatus(String loginName) {
        return statusRepository.getLatestStatusByLoginName(loginName);
    }/*
    public Status getLatestStatus(String loginName) {
        Page<Status> page = statusRepository.findLatestStatusByLoginName(loginName, PageRequest.of(0, 1));
        return page.getContent().isEmpty() ? null : page.getContent().get(0);
    }*/

    
}
