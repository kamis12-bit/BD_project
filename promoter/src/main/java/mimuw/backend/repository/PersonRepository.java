package mimuw.backend.repository;

import mimuw.backend.entity.Person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(
        value =
            "SELECT per.* FROM promoter_event_person ep " +
            "LEFT JOIN promoter_person per ON ep.person = per.id " +
            "WHERE ep.event = :eventId",
        nativeQuery = true)
    List<Person> findPeopleFromEvent(@Param("eventId") Long eventId);
}
