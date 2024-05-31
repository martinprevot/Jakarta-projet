package com.API.TP.service;

import com.API.TP.DTO.TicketDto;
import com.API.TP.model.Ticket;
import com.API.TP.model.User;
import com.API.TP.repository.TicketRepository;
import com.API.TP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.API.TP.model.Epreuve;


import com.API.TP.repository.EpreuveRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EpreuveRepository epreuveRepository;


    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket createTicket(TicketDto ticketDto) {
        User user = userRepository.findById(ticketDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + ticketDto.getUserId()));
        Epreuve epreuve = epreuveRepository.findById(ticketDto.getEpreuveId())
                .orElseThrow(() -> new RuntimeException("Epreuve not found with ID: " + ticketDto.getEpreuveId()));

        // Vérification de l'inscription existante à une épreuve à la même date
        boolean alreadyRegistered = ticketRepository.existsByUserAndEpreuveDate(user, epreuve.getDate());
        if (alreadyRegistered) {
            throw new RuntimeException("User is already registered for an event on this date.");
        }

        Ticket ticket = new Ticket();
        ticket.setTicketType(ticketDto.getTicketType());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setUser(user);
        ticket.setEpreuve(epreuve);
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    public List<Ticket> getTicketsByUserId(Long userId) {
        return ticketRepository.findByUserId(userId);
    }
}
