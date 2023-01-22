package mimuw.backend.service;

import mimuw.backend.dto.EventShortInfo;
import mimuw.backend.dto.MainViewEvent;
import mimuw.backend.entity.Event;
import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event updateEvent(Event event);

    void deleteEvent(Long id);

    Event getEventById(Long id);

    List<Event> getAllEvents();

    List<EventShortInfo> getAllEventsSortedByBeginDate();

    List<MainViewEvent> getMainViewEvents();
}
