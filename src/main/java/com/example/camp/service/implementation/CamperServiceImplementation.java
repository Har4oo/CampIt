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
        System.out.println("Listing camper with id: "+id);
        return camperRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id " + id));
    }

    @Override
    public Camper createCamper(Camper camper) {
        System.out.println("Creating camper: " + camper.getFirstName() + " " + camper.getLastName());
        return camperRepository.save(camper);
    }

    @Override
    public Camper updateCamper(Camper camper, Long id) {
        Camper existingCamper = camperRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id " + id));

        System.out.println("Updating camper with id: "+existingCamper.getId());

        existingCamper.setFirstName(camper.getFirstName());
        existingCamper.setLastName(camper.getLastName());
        existingCamper.setBirthDate(camper.getBirthDate());
        existingCamper.setTeam(camper.getTeam());
        existingCamper.setRole(camper.getRole());
        existingCamper.setMale(camper.isMale());

        return camperRepository.save(existingCamper);
    }

    @Override
    public void deleteCamper(Long id) {
        camperRepository.deleteById(id);
    }
}
