package mimuw.backend.repository;

import mimuw.backend.entity.EventPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventPersonRepository extends JpaRepository<EventPerson, Long> {
    @Query (
        value = 
            "SELECT COUNT(*) " + 
            "FROM promoter_event_person " + 
            "WHERE person = :personId ",
        nativeQuery = true)
    Integer countEventPersonsByPerson(@Param("personId") Long personId);

    @Modifying
    @Query (
        value = 
            "DELETE FROM promoter_event_person " + 
            "WHERE event = :eventId ",
        nativeQuery = true)
    void deleteEventPersonsByEvent(@Param("eventId") Long eventId);

    @Query (
        value =
            "SELECT person " +
            "FROM promoter_event_person " +
            "WHERE event = :eventId ",
        nativeQuery = true)
    List<Long> getPersonsIdByEvent(@Param("eventId") Long eventId);
}
