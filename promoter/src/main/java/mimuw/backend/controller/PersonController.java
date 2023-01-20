package mimuw.backend.controller;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.Person;
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
//    private PersonService personService;

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
//        Person createdPerson = personService.createPerson(person);
        Person createdPerson = new Person();
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
//        Person updatedPerson = personService.updatePerson(person);
        Person updatedPerson = new Person();
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
//        personService.deletePerson(id);
        return new ResponseEntity<>("Person successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
//        Person person = personService.getPersonById(id);
        Person person = new Person();
        if (id == 1) {
            person.setId(1L);
            person.setFirstName("Wojciech");
            person.setLastName("Weremczuk");
            person.setAvatar("img_avatar1.png");
        } else {
            person.setId(2L);
            person.setFirstName("Krzysztof");
            person.setLastName("Szostek");
            person.setAvatar("img_avatar2.png");
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons() {
//        List<Person> persons = personService.getAllPersons();
        List<Person> persons = List.of(
                new Person(1L, "Wojciech", "Weremczuk", "img_avatar1.png"),new Person(2L, "Krzysztof", "Szostek", "img_avatar2.png")
        );
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
