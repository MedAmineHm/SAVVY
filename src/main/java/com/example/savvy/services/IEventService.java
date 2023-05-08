package com.example.savvy.services;

import com.example.savvy.entites.Event;

import java.util.List;

public interface IEventService {

    public List<Event> getAllEvents();
    public Event getEventById(Long idEvent);
    public Event createEvent(Event event);
    public Event updateEvent(Event event);
    public void deleteEvent(Long idevent);
}
