package mimuw.backend.service;

import mimuw.backend.dto.PersonDto;
import mimuw.backend.entity.Person;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PersonService {
        Person createPerson(String firstName, String lastName, MultipartFile avatar) throws IOException;

        Person updatePerson(Long id, String firstName, String lastName, MultipartFile avatar) throws IOException;

        void deletePerson(Long id);

        Person getPersonById(Long id);

        List<Person> getAllPersons();

        List<Person> getPersonsByEventId(Long eventId);
}
