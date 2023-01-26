package mimuw.backend.controller;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.Person;
import mimuw.backend.service.DescriptionService;
import mimuw.backend.service.EventPersonService;
import mimuw.backend.service.GraphicsService;
import mimuw.backend.service.MessagePersonService;
import mimuw.backend.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/person")
@CrossOrigin("http://localhost:3000")
public class PersonController {
    private PersonService personService;
    private GraphicsService graphicsService;
    private DescriptionService descriptionService;
    private EventPersonService eventPersonService;
    private MessagePersonService messagePersonService;

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.createPerson(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        Person updatedPerson = personService.updatePerson(person);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        Integer countGraphics = graphicsService.countGraphicsBySupervisor(id);
        Integer countDescriptions = descriptionService.countDescriptionsBySupervisor(id);
        Integer countEvent = eventPersonService.countEventPersonsByPerson(id);
        Integer countMessages = messagePersonService.countMessagePersonsByPerson(id);

        if (countGraphics > 0 || countDescriptions > 0 || countEvent > 0 || countMessages > 0) {
            return new ResponseEntity<>(
                "Cannot delete Person, because it is responsible for " + countEvent + " Events, " 
                    + countMessages + " PromoMessages, " + countGraphics + " Graphics and " 
                    + countDescriptions + " Descriptions!",
                HttpStatus.BAD_REQUEST);
        }

        personService.deletePerson(id);
        return new ResponseEntity<>("Person successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons() {
         List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/all-from-event/{id}")
    public ResponseEntity<List<Person>> getAllPersonsFromEvent(@PathVariable Long id) {
        List<Person> persons = personService.getPersonsByEventId(id);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
