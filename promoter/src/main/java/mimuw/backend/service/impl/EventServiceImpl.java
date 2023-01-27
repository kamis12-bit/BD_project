package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.dto.DetailViewEvent;
import mimuw.backend.dto.MainViewEvent;
import mimuw.backend.entity.Event;
import mimuw.backend.entity.EventPerson;
import mimuw.backend.repository.EventPersonRepository;
import mimuw.backend.repository.EventRepository;
import mimuw.backend.repository.PromoMessageRepository;
import mimuw.backend.service.EventService;
import mimuw.backend.service.PersonService;
import mimuw.backend.service.PromoMessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private EventPersonRepository eventPersonRepository;
    private PromoMessageRepository promoMessageRepository;
    private PersonService personService;
    private PromoMessageService promoMessageService;

    private List<MainViewEvent> createResultForSelectedEvents(List<Event> events) {
        List<MainViewEvent> mainViewEvents = new ArrayList<>();

        for (Event event: events) {
            MainViewEvent mainViewEvent = new MainViewEvent();
            mainViewEvent.setId(event.getId());
            mainViewEvent.setName(event.getName());
            mainViewEvent.setBeginDate(event.getBeginDate());
            mainViewEvent.setEndDate(event.getEndDate());
            mainViewEvent.setPersons(personService.getPersonsByEventId(event.getId()));
            mainViewEvent.setIsPublished(promoMessageService.isPromoMessagePublishedByEvent(event.getId()));
            mainViewEvents.add(mainViewEvent);
        }
        return mainViewEvents;
    }

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
    public List<Event> getAllUnarchivedEvents() {
        return eventRepository.getAllUnarchivedEvents();
    }

    @Override
    public List<Event> getAllArchivedEvents() {
        return eventRepository.getAllArchivedEvents();
    }

    @Override
    public List<MainViewEvent> getMainViewEvents() {
        return createResultForSelectedEvents(eventRepository.getAllUnarchivedEvents());
    }

    @Override
    public List<MainViewEvent> getArchivedViewEvents() {
        return createResultForSelectedEvents(eventRepository.getAllArchivedEvents());
    }

    @Override
    public Event duplicateEvent(Long id) {
        Event eventToDuplicate = getEventById(id);
        Event duplicatedEvent = new Event(eventToDuplicate);

        Event createdEvent = eventRepository.save(duplicatedEvent);
        Long newId = createdEvent.getId();

        List<Long> personsId = eventPersonRepository.getPersonsIdByEvent(id);
        for (Long personId: personsId) {
            EventPerson eventPerson = new EventPerson();
            eventPerson.setPerson(personId);
            eventPerson.setEvent(newId);
            eventPersonRepository.save(eventPerson);
        }

        promoMessageService.duplicatePromoMessagesByEvent(id, newId);
        return createdEvent;
    }

    @Override
    public DetailViewEvent getDetailViewEvent(Long id) {
        Event event = getEventById(id);
        DetailViewEvent detailViewEvent = new DetailViewEvent();
        detailViewEvent.setId(event.getId());
        detailViewEvent.setName(event.getName());
        detailViewEvent.setDescription(event.getDescription());
        detailViewEvent.setBeginDate(event.getBeginDate());
        detailViewEvent.setEndDate(event.getEndDate());
        detailViewEvent.setArchived(event.getArchived());
        detailViewEvent.setIsPublished(promoMessageService.isPromoMessagePublishedByEvent(event.getId()));
        detailViewEvent.setPersons(personService.getPersonsByEventId(event.getId()));
        detailViewEvent.setPromoMessages(promoMessageRepository.getPromoMessagesByEvent(event.getId()));
        return detailViewEvent;
    }
}
