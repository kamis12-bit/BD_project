package mimuw.backend.controller;

import lombok.AllArgsConstructor;
import mimuw.backend.dto.MainViewEvent;
import mimuw.backend.entity.Event;
import mimuw.backend.service.EventPersonService;
import mimuw.backend.service.EventService;
import mimuw.backend.service.PromoMessageService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/event")
public class EventController {
    private EventService eventService;
    private EventPersonService eventPersonService;
    private PromoMessageService promoMessageService;

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        event.setId(id);
        Event updatedEvent = eventService.updateEvent(event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventPersonService.deleteEventPersonsByEvent(id);
        promoMessageService.deletePromoMessagesByEvent(id);
        eventService.deleteEvent(id);
        return new ResponseEntity<>("Event successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/all-unarchived")
    public ResponseEntity<List<Event>> getAllUnarchivedEvents() {
        List<Event> events = eventService.getAllUnarchivedEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/all-archived")
    public ResponseEntity<List<Event>> getAllArchivedEvents() {
        List<Event> events = eventService.getAllArchivedEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/main-view")
    public ResponseEntity<List<MainViewEvent>> getMainViewEvents() {
        List<MainViewEvent> mainViewEvents = eventService.getMainViewEvents();
        return new ResponseEntity<>(mainViewEvents, HttpStatus.OK);
    }

    @GetMapping("/archived-view")
    public ResponseEntity<List<MainViewEvent>> getArchivedViewEvents() {
        List<MainViewEvent> archivedViewEvents = eventService.getArchivedViewEvents();
        return new ResponseEntity<>(archivedViewEvents, HttpStatus.OK);
    }

    @GetMapping("/archive/{id}")
    public ResponseEntity<Event> archiveEvent(@PathVariable Long id){
        Event event = eventService.getEventById(id);
        event.setArchived(1);
        Event updatedEvent = eventService.updateEvent(event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @GetMapping("/unarchive/{id}")
    public ResponseEntity<Event> unarchiveEvent(@PathVariable Long id){
        Event event = eventService.getEventById(id);
        event.setArchived(0);
        Event updatedEvent = eventService.updateEvent(event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @GetMapping("duplicate/{id}")
    public ResponseEntity<Event> duplicateEvent(@PathVariable Long id){
        Event createdEvent = eventService.duplicateEvent(id);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }
}
