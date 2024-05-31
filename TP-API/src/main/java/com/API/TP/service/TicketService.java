package com.API.TP.service;

import com.API.TP.DTO.TicketDto;
import com.API.TP.model.Ticket;
import com.API.TP.model.User;
import com.API.TP.repository.TicketRepository;
import com.API.TP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket createTicket(TicketDto ticketDto) {
        User user = userRepository.findById(ticketDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User inconnu avec id: " + ticketDto.getUserId()));
        Ticket ticket = new Ticket();
        ticket.setTicketType(ticketDto.getTicketType());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setUser(user);
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
