package mimuw.backend.repository;

import mimuw.backend.entity.Event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(
        value =
            "SELECT * FROM promoter_event " +
            "WHERE archived = 0 " +
            "ORDER BY begin_date ",
        nativeQuery = true)
    List<Event> getAllUnarchivedEvents();

    @Query(
        value =
            "SELECT * FROM promoter_event " +
            "WHERE archived = 1 " +
            "ORDER BY begin_date ",
        nativeQuery = true)
    List<Event> getAllArchivedEvents();
}
