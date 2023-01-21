package mimuw.backend;

import mimuw.backend.entity.Person;
import mimuw.backend.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
    private static PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);

        Person person = new Person(3L, "Jan", "Kowalski", "avatar_Jan_Kowalski.png");
        System.out.println(person);

        Person createdPerson = personService.createPerson(person);
    }

}
