package mimuw.backend.service;

import mimuw.backend.entity.EventPerson;
import java.util.List;

public interface EventPersonService {
    EventPerson createEventPerson(EventPerson eventPerson);

    EventPerson updateEventPerson(EventPerson eventPerson);

    void deleteEventPerson(Long id);

    void deleteEventPersonsByEvent(Long eventId);

    EventPerson getEventPersonById(Long id);

    List<EventPerson> getAllEventPersons();

    Integer countEventPersonsByPerson(Long personId);
}
