package com.API.TP.repository;

import com.API.TP.model.Ticket;
import com.API.TP.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUserId(Long userId);


    @Query("SELECT COUNT(t) > 0 FROM Ticket t WHERE t.user = :user AND t.epreuve.date = :date")
    boolean existsByUserAndEpreuveDate(User user, Date date);
}