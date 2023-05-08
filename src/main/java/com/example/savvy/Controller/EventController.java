package com.example.savvy.Controller;

import com.example.savvy.Repository.IEventRepository;
import com.example.savvy.entites.Event;
import com.example.savvy.entites.Reservation;
import com.example.savvy.services.ServiceEventImpl;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
@Slf4j
@CrossOrigin(origins = "http://localhost:4200/")
public class EventController {

    @Autowired
    ServiceEventImpl serviceEvent;
    @Autowired
    IEventRepository eventRepository;

    @GetMapping("/GetAllEvent")
    public List<Event> getAllEvent(){
        return serviceEvent.getAllEvents();
    }

    @PostMapping("/addEvent")
    public Event addEvent(@RequestParam("event") String event,@RequestParam("image") MultipartFile file) throws IOException {

        Event ev = new Gson().fromJson(event, Event.class);


        String image=file.getOriginalFilename();
        String path="C:/Users/GOLDEN/Desktop/Inceptum Workshop/xampp/htdocs/img";

        byte[] bytes = image.getBytes();
        int image2=bytes.toString().hashCode();
        Files.copy(file.getInputStream(), Paths.get(path+ File.separator+image2+".jpg"));

        ev.setImage(""+image2);
        return serviceEvent.createEvent(ev);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public void deleteEvent(@PathVariable("id") Long id){
        serviceEvent.deleteEvent(id);
    }

    @GetMapping("/Event/{id}")
    public Event getEventById(@PathVariable("id") Long id){
        return serviceEvent.getEventById(id);
    }

    @PutMapping("/updateEvent")
    public Event updateReservation(@RequestBody Event  event){
        return serviceEvent.updateEvent(event);
    }
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getEventsBetweenDates(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<Event> events = eventRepository.findEventsBetweenDates(startDate, endDate);

        return ResponseEntity.ok(events);
    }
}
