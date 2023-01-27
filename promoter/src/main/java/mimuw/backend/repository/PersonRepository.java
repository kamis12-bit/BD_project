package mimuw.backend.repository;

import mimuw.backend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(
        value =
            "SELECT per.* FROM promoter_event_person ep " +
            "LEFT JOIN promoter_person per ON ep.person = per.id " +
            "WHERE ep.event = :eventId",
        nativeQuery = true)
    List<Person> findPeopleFromEvent(@Param("eventId") Long eventId);
}
