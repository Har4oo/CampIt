package com.example.camp.service;

import com.example.camp.repository.CamperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final CamperRepository camperRepository;

    @Autowired
    public TeamService(CamperRepository camperRepository) {
        this.camperRepository = camperRepository;
    }
}
