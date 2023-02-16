package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.dto.PersonDto;
import mimuw.backend.entity.Person;
import mimuw.backend.repository.PersonRepository;
import mimuw.backend.service.PersonService;
import mimuw.backend.util.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public Person createPerson(String firstName, String lastName, MultipartFile avatar) throws IOException {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
//        person.setAvatar(ImageUtil.compressImage(avatar.getBytes()));
        person.setAvatar(avatar.getBytes());
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, String firstName, String lastName, MultipartFile avatar) throws IOException {
        Person personToUpdate = personRepository.findById(id).orElseThrow();
        personToUpdate.setFirstName(firstName);
        personToUpdate.setLastName(lastName);
//        personToUpdate.setAvatar(ImageUtil.compressImage(avatar.getBytes()));
        personToUpdate.setAvatar(avatar.getBytes());
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

    @Override
    public List<Person> getPersonsByEventId(Long eventId) {
        return personRepository.findPeopleFromEvent(eventId);
    }
}
