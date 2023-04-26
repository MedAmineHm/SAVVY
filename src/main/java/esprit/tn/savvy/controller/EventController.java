package esprit.tn.savvy.controller;


import esprit.tn.savvy.Repository.EventRepository;
import esprit.tn.savvy.entities.Event;

import esprit.tn.savvy.services.IserviceEvent;
import lombok.AllArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@AllArgsConstructor
public class EventController {

    IserviceEvent iserviceEvent;
    EventRepository eventRepository;



    @GetMapping(path = "/show")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/{idEvent}")
    public Event getEventById(@PathVariable Long idEvent) {
        return iserviceEvent.getEventById(idEvent);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {

        return iserviceEvent.createEvent(event);
    }
    @PutMapping("/{idEvent}")
    public Event updateEvent(@PathVariable Long idEvent, @RequestBody Event event) {
        event.setIdEvent(idEvent);
        return iserviceEvent.updateEvent(event);
    }
    @DeleteMapping("/{idEvent}")
    public void deleteEvent(@PathVariable Long idEvent) {
        Event event = iserviceEvent.getEventById(idEvent) ;
        iserviceEvent.deleteEvent(event);
    }
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getEventsBetweenDates(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<Event> events = eventRepository.findEventsBetweenDates(startDate, endDate);

        return ResponseEntity.ok(events);
    }
}

