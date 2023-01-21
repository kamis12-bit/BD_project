package mimuw.backend.service;

import mimuw.backend.entity.Person;
import java.util.List;

public interface PersonService {

        Person createPerson(Person person);

        Person updatePerson(Person person);

        void deletePerson(Long id);

        Person getPersonById(Long id);

        List<Person> getAllPersons();

        List<Person> getPeopleWithNameWojciech();
}
