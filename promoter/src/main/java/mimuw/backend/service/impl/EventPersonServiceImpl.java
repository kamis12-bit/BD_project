package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.EventPerson;
import mimuw.backend.repository.EventPersonRepository;
import mimuw.backend.service.EventPersonService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EventPersonServiceImpl implements EventPersonService{
    EventPersonRepository eventPersonRepository;

    @Override
    public EventPerson createEventPerson(EventPerson eventPerson) {
        return eventPersonRepository.save(eventPerson);
    }

    @Override
    public EventPerson updateEventPerson(EventPerson eventPerson) {
        EventPerson eventPersonToUpdate = eventPersonRepository.findById(eventPerson.getId()).orElseThrow();
        eventPersonToUpdate.setEvent(eventPerson.getEvent());
        eventPersonToUpdate.setPerson(eventPerson.getPerson());
        return eventPersonRepository.save(eventPersonToUpdate);
    }

    @Override
    public void deleteEventPerson(Long id) {
        eventPersonRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteEventPersonsByEvent(Long eventId) {
        eventPersonRepository.deleteEventPersonsByEvent(eventId);
    }

    @Override
    public EventPerson getEventPersonById(Long id) {
        return eventPersonRepository.findById(id).orElseThrow();
    }

    @Override
    public List<EventPerson> getAllEventPersons() {
        return eventPersonRepository.findAll();
    }

    @Override
    public Integer countEventPersonsByPerson(Long personId) {
        return eventPersonRepository.countEventPersonsByPerson(personId);
    }

    
}
