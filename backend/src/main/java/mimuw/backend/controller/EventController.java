package mimuw.backend.controller;

import lombok.AllArgsConstructor;
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
//        Event createdEvent = eventService.createEvent(event);
        Event createdEvent = event;
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        event.setId(id);
//        Event updatedEvent = eventService.updateEvent(event);
        Event updatedEvent = event;
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
//        eventService.deleteEvent(id);
        return new ResponseEntity<>("Event successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
//        Event event = eventService.getEventById(id);
        Event event;
        if (id == 1)
            event = new Event(1L, "name", "description", "beginDate", "endDate", 0);
        else
            event = new Event(2L, "name2", "description2", "beginDate2", "endDate2", 1);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
//        List<Event> events = eventService.getAllEvents();
        List<Event> events = List.of(
            new Event(1L, "name", "description", "beginDate", "endDate", 0),
            new Event(2L, "name2", "description2", "beginDate2", "endDate2", 1)
        );
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
