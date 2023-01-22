package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.dto.EventShortInfo;
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
    public List<EventShortInfo> getAllEventsSortedByBeginDate() {
        List<Object[]> objects = eventRepository.getAllEventsSortedByBeginDate();
        List<EventShortInfo> events = new ArrayList<>();
        for (Object[] object : objects) {
            EventShortInfo event = new EventShortInfo();
            event.setId((Long) object[0]);
            event.setName((String) object[1]);
            event.setBeginDate((String) object[2]);
            event.setEndDate((String) object[3]);
            events.add(event);
        }
        return events;
    }

    @Override
    public List<MainViewEvent> getMainViewEvents() {
        List<Object[]> objects = eventRepository.getAllEventsSortedByBeginDate();

        List<MainViewEvent> events = new ArrayList<>();
        for (Object[] object : objects) {
            MainViewEvent event = new MainViewEvent();
            event.setId((Long) object[0]);
            event.setName((String) object[1]);
            event.setBeginDate((String) object[2]);
            event.setEndDate((String) object[3]);
            event.setPersons(personService.getPersonsByEventId(event.getId()));
            events.add(event);
        }
        return events;
    }
}
