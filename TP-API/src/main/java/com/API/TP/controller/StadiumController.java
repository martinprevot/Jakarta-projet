package com.API.TP.controller;

import com.API.TP.model.Stadium;
import com.API.TP.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;

    @GetMapping
    public List<Stadium> getAllStadiums() {
        return stadiumService.getAllStadiums();
    }

    @GetMapping("/{id}")
    public Stadium getStadiumById(@PathVariable Long id) {
        return stadiumService.getStadiumById(id)
                .orElseThrow(() -> new RuntimeException("Stade inconnu avec id:  " + id));
    }

    @PostMapping
    public Stadium createStadium(@RequestBody Stadium stadium) {
        return stadiumService.createStadium(stadium);
    }

    @PutMapping("/{id}")
    public Stadium updateStadium(@PathVariable Long id, @RequestBody Stadium stadiumDetails) {
        Stadium stadium = stadiumService.getStadiumById(id)
                .orElseThrow(() -> new RuntimeException("Stade inconnu avec id: " + id));
        stadium.setNom(stadiumDetails.getNom());
        stadium.setLocalisation(stadiumDetails.getLocalisation());
        return stadiumService.updateStadium(stadium);
    }

    @DeleteMapping("/{id}")
    public void deleteStadium(@PathVariable Long id) {
        stadiumService.deleteStadium(id);
    }



}
