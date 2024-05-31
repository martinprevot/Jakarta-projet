package com.API.TP.service;


import com.API.TP.model.Epreuve;
import com.API.TP.repository.EpreuveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpreuveService {


    @Autowired
    private EpreuveRepository epreuveRepository;

    public List<Epreuve> getAllEpreuves() {
        return epreuveRepository.findAll();
    }

    public Optional<Epreuve> getEpreuveById(Long id) {
        return epreuveRepository.findById(id);
    }

    public Epreuve createEpreuve(Epreuve epreuve) {
        return epreuveRepository.save(epreuve);
    }

    public Epreuve updateEpreuve(Epreuve epreuve) {
        return epreuveRepository.save(epreuve);
    }

    public void deleteEpreuve(Long id) {
        epreuveRepository.deleteById(id);
    }

    public List<Epreuve> getEpreuvesByEventId(Long eventId) {
        return epreuveRepository.findByEventId(eventId);
    }

}
