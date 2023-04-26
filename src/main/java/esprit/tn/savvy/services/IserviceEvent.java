package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.Event;

import java.util.Date;
import java.util.List;

public interface IserviceEvent {
    public List<Event> getAllEvents();
    public Event getEventById(Long idEvent);
    public Event createEvent(Event event);
    public Event updateEvent(Event event);
    public void deleteEvent(Event event);




}
