package com.API.TP.controller;

import com.API.TP.model.Event;
import com.API.TP.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .orElseThrow(() -> new RuntimeException("Event inconnu avec id: " + id));
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Event event = eventService.getEventById(id)
                .orElseThrow(() -> new RuntimeException("Event inconnu avec id: " + id));
        event.setNom(eventDetails.getNom());
        event.setDate(eventDetails.getDate());
        event.setLieu(eventDetails.getLieu());
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
