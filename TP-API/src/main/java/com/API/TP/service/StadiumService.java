package com.API.TP.service;

import com.API.TP.model.Stadium;
import com.API.TP.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StadiumService {

    @Autowired
    private StadiumRepository stadiumRepository;

    public List<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }

    public Optional<Stadium> getStadiumById(Long id) {
        return stadiumRepository.findById(id);
    }

    public Stadium createStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public Stadium updateStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public void deleteStadium(Long id) {
        stadiumRepository.deleteById(id);
    }
}
