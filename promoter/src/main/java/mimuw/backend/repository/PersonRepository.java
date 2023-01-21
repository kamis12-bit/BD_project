package mimuw.backend.repository;

import mimuw.backend.entity.Person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(
        value = "SELECT * FROM promoter_person WHERE first_name = 'Wojciech' ", 
        nativeQuery = true)
    List<Person> findPeopleWithNameWojciech();
}
