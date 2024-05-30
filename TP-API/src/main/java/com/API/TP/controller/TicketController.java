package com.API.TP.controller;

import com.API.TP.DTO.TicketDto;
import com.API.TP.model.Ticket;
import com.API.TP.model.User;
import com.API.TP.service.TicketService;
import com.API.TP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private UserService userService;


    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id)
                .orElseThrow(() -> new RuntimeException("Ticket inconnu avec id:  " + id));
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        Ticket ticket = ticketService.getTicketById(id)
                .orElseThrow(() -> new RuntimeException("Ticket inconnu avec id: " + id));
        ticket.setTicketType(ticketDetails.getTicketType());
        ticket.setPrice(ticketDetails.getPrice());
        return ticketService.updateTicket(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }

    @GetMapping("/user/{userId}")
    public List<Ticket> getTicketsByUserId(@PathVariable Long userId) {
        return ticketService.getTicketsByUserId(userId);
    }

    @PostMapping("/tickets")
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketDto ticketDto) {
        User user = userService.getUserById(ticketDto.getUserId()).orElseThrow(() -> new RuntimeException("User inconnu " + ticketDto.getUserId()));

        Ticket ticket = new Ticket();
        ticket.setTicketType(ticketDto.getTicketType());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setUser(user);

        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.ok(createdTicket);
    }

}
