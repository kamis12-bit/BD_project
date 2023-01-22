package mimuw.backend.repository;

import mimuw.backend.entity.Event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(
        value =
            "SELECT id, name, begin_date, end_date " +
            "FROM promoter_event " +
            "WHERE archived = 0 " +
            "ORDER BY begin_date ",
        nativeQuery = true)
    List<Object[]> getAllEventsSortedByBeginDate();
}
