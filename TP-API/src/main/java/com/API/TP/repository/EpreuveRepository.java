package com.API.TP.repository;

import com.API.TP.model.Epreuve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpreuveRepository extends JpaRepository<Epreuve, Long> {

    List<Epreuve> findByEventId(Long eventId);
}
