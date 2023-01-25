package mimuw.backend.service;

import mimuw.backend.entity.EventPerson;
import java.util.List;

public interface EventPersonService {
    EventPerson createEventPerson(EventPerson eventPerson);

    EventPerson updateEventPerson(EventPerson eventPerson);

    void deleteEventPerson(Long id);

    EventPerson getEventPersonById(Long id);

    List<EventPerson> getAllEventPersons();
}
