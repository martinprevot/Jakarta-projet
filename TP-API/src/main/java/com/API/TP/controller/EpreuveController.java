package com.API.TP.controller;

import com.API.TP.model.Epreuve;
import com.API.TP.service.EpreuveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epreuves")
public class EpreuveController {

    @Autowired
    private EpreuveService epreuveService;

    @GetMapping
    public List<Epreuve> getAllEpreuves() {
        return epreuveService.getAllEpreuves();
    }

    //
    @GetMapping("/{id}")
    public Epreuve getEpreuveById(@PathVariable Long id) {
        return epreuveService.getEpreuveById(id)
                .orElseThrow(() -> new RuntimeException("Epreuve inconnu avec id: " + id));
    }
//

    @PostMapping
    public Epreuve createEpreuve(@RequestBody Epreuve epreuve) {
        return epreuveService.createEpreuve(epreuve);
    }

    @PutMapping("/{id}")
    public Epreuve updateEpreuve(@PathVariable Long id, @RequestBody Epreuve epreuveDetails) {
        Epreuve epreuve = epreuveService.getEpreuveById(id)
                .orElseThrow(() -> new RuntimeException("Epreuve inconnu avec id: " + id));
        epreuve.setNom(epreuveDetails.getNom());
        epreuve.setDate(epreuveDetails.getDate());
        return epreuveService.updateEpreuve(epreuve);
    }

    @DeleteMapping("/{id}")
    public void deleteEpreuve(@PathVariable Long id) {
        epreuveService.deleteEpreuve(id);
    }

    @GetMapping("/event/{eventId}")
    public List<Epreuve> getEpreuvesByEventId(@PathVariable Long eventId) {
        return epreuveService.getEpreuvesByEventId(eventId);
    }

}
