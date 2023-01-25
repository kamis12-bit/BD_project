package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.EventPerson;
import mimuw.backend.repository.EventPersonRepository;
import mimuw.backend.service.EventPersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventPersonServiceImpl implements EventPersonService{
    EventPersonRepository eventPersonRepository;

    public EventPerson createEventPerson(EventPerson eventPerson) {
        return eventPersonRepository.save(eventPerson);
    }

    public EventPerson updateEventPerson(EventPerson eventPerson) {
        EventPerson eventPersonToUpdate = eventPersonRepository.findById(eventPerson.getId()).orElseThrow();
        eventPersonToUpdate.setEvent(eventPerson.getEvent());
        eventPersonToUpdate.setPerson(eventPerson.getPerson());
        return eventPersonRepository.save(eventPersonToUpdate);
    }

    public void deleteEventPerson(Long id) {
        eventPersonRepository.deleteById(id);
    }

    public EventPerson getEventPersonById(Long id) {
        return eventPersonRepository.findById(id).orElseThrow();
    }

    public List<EventPerson> getAllEventPersons() {
        return eventPersonRepository.findAll();
    }
}
