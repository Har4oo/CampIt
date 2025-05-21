package com.example.camp.service.implementation;

import com.example.camp.repository.CamperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImplementation {
    private final CamperRepository camperRepository;

    @Autowired
    public TeamServiceImplementation(CamperRepository camperRepository) {
        this.camperRepository = camperRepository;
    }
}
