package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.Person;
import mimuw.backend.repository.PersonRepository;
import mimuw.backend.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        Person personToUpdate = personRepository.findById(person.getId()).orElseThrow();
        personToUpdate.setFirstName(person.getFirstName());
        personToUpdate.setLastName(person.getLastName());
        personToUpdate.setAvatar(person.getAvatar());
        return personRepository.save(personToUpdate);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
