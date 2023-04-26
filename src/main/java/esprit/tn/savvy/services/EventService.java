package esprit.tn.savvy.services;

import esprit.tn.savvy.Repository.EventRepository;
import esprit.tn.savvy.entities.Event;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class EventService implements IserviceEvent  {


    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long idEvent) {
        return eventRepository.findById(idEvent).orElseThrow(()->new IllegalArgumentException("eeee"));
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(@NotNull Event event) {
        eventRepository.deleteById(event.getIdEvent());

    }






    public List<Event> getEventsByUserId(Long userId) {
        return null;
    }

}


