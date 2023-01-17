package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.Event;
import mimuw.backend.repository.EventRepository;
import mimuw.backend.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        Event eventToUpdate = eventRepository.findById(event.getId()).orElseThrow();
        eventToUpdate.setName(event.getName());
        eventToUpdate.setDescription(event.getDescription());
        eventToUpdate.setBeginDate(event.getBeginDate());
        eventToUpdate.setEndDate(event.getEndDate());
        eventToUpdate.setArchived(event.getArchived());
        return eventRepository.save(eventToUpdate);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
