package mimuw.backend.controller;

import lombok.AllArgsConstructor;
import mimuw.backend.dto.EventShortInfo;
import mimuw.backend.dto.MainViewEvent;
import mimuw.backend.entity.Event;
import mimuw.backend.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/event")
public class EventController {
    private EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
//        Event createdEvent = new Event();
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        event.setId(id);
        Event updatedEvent = eventService.updateEvent(event);
//        Event updatedEvent = new Event();
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>("Event successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
//        Event event = new Event();
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
//        List<Event> events = List.of(new Event(), new Event());
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/all-sorted")
    public ResponseEntity<List<EventShortInfo>> getAllEventsSortedByBeginDate() {
        List<EventShortInfo> events = eventService.getAllEventsSortedByBeginDate();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/main-view")
    public ResponseEntity<List<MainViewEvent>> getMainViewEvents() {
        List<MainViewEvent> mainViewEvents = eventService.getMainViewEvents();
        return new ResponseEntity<>(mainViewEvents, HttpStatus.OK);
    }
}
