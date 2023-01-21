package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.dto.MainViewEvent;
import mimuw.backend.entity.Event;
import mimuw.backend.repository.EventRepository;
import mimuw.backend.service.EventService;
import mimuw.backend.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private PersonService personService;

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

    @Override
    public List<Event> getAllEventsSortedByBeginDate() {
        return eventRepository.getAllEventsSortedByBeginDate();
    }

    @Override
    public List<MainViewEvent> getMainViewEvents() {
        List<Event> events = eventRepository.getAllEventsSortedByBeginDate();
        List<MainViewEvent> mainViewEvents = new ArrayList<>();

        for (Event event: events) {
            MainViewEvent mainViewEvent = new MainViewEvent();
            mainViewEvent.setId(event.getId());
            mainViewEvent.setName(event.getName());
            mainViewEvent.setBeginDate(event.getBeginDate());
            mainViewEvent.setEndDate(event.getEndDate());
            mainViewEvent.setPersons(personService.getPersonsByEventId(event.getId()));
            mainViewEvents.add(mainViewEvent);
        }
        return mainViewEvents;
    }
}
