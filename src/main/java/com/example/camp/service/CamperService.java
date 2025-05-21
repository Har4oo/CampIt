package com.example.camp.service;

import com.example.camp.model.Camper;

import java.util.List;

public interface CamperService {
    List<Camper> getCampers();
    Camper getCamper(Long id);
    Camper createCamper(Camper camper);
    Camper updateCamper(Camper camper, Long id);
    void deleteCamper(Long id);
}
