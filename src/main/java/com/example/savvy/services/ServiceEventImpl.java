package com.example.savvy.services;


import com.example.savvy.Repository.IEventRepository;
import com.example.savvy.entites.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEventImpl implements  IEventService{
    @Autowired
    IEventRepository iEventRepository;
    @Override
    public List<Event> getAllEvents() {
        return iEventRepository.findAll();
    }

    @Override
    public Event getEventById(Long idEvent) {
        return iEventRepository.findById(idEvent).get();
    }

    @Override
    public Event createEvent(Event event) {
        return iEventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return iEventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long event) {
        iEventRepository.deleteById(event);
    }


}
