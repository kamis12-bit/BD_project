package mimuw.backend.repository;

import mimuw.backend.entity.Event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long> {
    // @Query(
    //     value = "SELECT ev.id, ev.name, ev.description, ev.begin_date, ev.end_date, ev.archived FROM promoter_event ev LEFT JOIN promoter_event_person ep ON ep.event = ep.id LEFT JOIN promoter_person per ON ev.person = per.id ORDER BY ev.begin_date",
    //     nativeQuery = true)
    @Query(
        value = "SELECT ev.* FROM promoter_event ev " +
            "LEFT JOIN promoter_event_person ep ON ep.event = ev.id " +
            "LEFT JOIN promoter_person pe ON ep.person = pe.id " +
            "WHERE ev.archived = 0 " +
            "ORDER BY ev.begin_date ",
        nativeQuery = true)
    List<Event> getAllEventsFromJoin();
}
