package com.example.camp.service.implementation;

import com.example.camp.model.Camper;
import com.example.camp.repository.CamperRepository;
import com.example.camp.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CamperServiceImplementation implements CamperService {
    private final CamperRepository camperRepository;

    @Autowired
    public CamperServiceImplementation(CamperRepository camperRepository) {
        this.camperRepository = camperRepository;
    }

    @Override
    public List<Camper> getCampers() {
        System.out.println("Listing all campers");
        return camperRepository.findAll();
    }

    @Override
    public Camper getCamper(Long id) {
        return camperRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id " + id));
    }

    @Override
    public Camper createCamper(Camper camper) {
        return null;
    }

    @Override
    public Camper updateCamper(Camper camper, Long id) {
        return null;
    }

    @Override
    public void deleteCamper(Long id) {

    }
}
