package mimuw.backend.controller;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.EventPerson;
import mimuw.backend.service.EventPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/event-person")
public class EventPersonController {
    private EventPersonService eventPersonService;

    @PostMapping("/create")
    public ResponseEntity<EventPerson> createEventPerson(@RequestBody EventPerson eventPerson) {
        EventPerson createdEventPerson = eventPersonService.createEventPerson(eventPerson);
        return new ResponseEntity<>(createdEventPerson, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EventPerson> updateEventPerson(@PathVariable Long id, @RequestBody EventPerson eventPerson) {
        eventPerson.setId(id);
        EventPerson updatedEventPerson = eventPersonService.updateEventPerson(eventPerson);
        return new ResponseEntity<>(updatedEventPerson, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEventPerson(@PathVariable Long id) {
        eventPersonService.deleteEventPerson(id);
        return new ResponseEntity<>("RelationshipEventPerson successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EventPerson> getEventPersonById(@PathVariable Long id) {
        EventPerson eventPerson = eventPersonService.getEventPersonById(id);
        return new ResponseEntity<>(eventPerson, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventPerson>> getAllEventPersons() {
        List<EventPerson> eventPeople = eventPersonService.getAllEventPersons();
        return new ResponseEntity<>(eventPeople, HttpStatus.OK);
    }
}
