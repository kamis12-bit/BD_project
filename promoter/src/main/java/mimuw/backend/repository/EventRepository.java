package mimuw.backend.repository;

import mimuw.backend.dto.EventShortInfo;
import mimuw.backend.entity.Event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long> {
//    @Query(
//        value = "SELECT ev.* FROM promoter_event ev " +
//            "LEFT JOIN promoter_event_person ep ON ep.event = ev.id " +
//            "LEFT JOIN promoter_person pe ON ep.person = pe.id " +
//            "WHERE ev.archived = 0 " +
//            "ORDER BY ev.begin_date ",
//        nativeQuery = true)
//    List<Event> getAllEventsSortedByBeginDate();

    @Query(
        value =
            "SELECT id, name, begin_date, end_date FROM promoter_event " +
            "WHERE archived = 0 " +
            "ORDER BY begin_date ",
        nativeQuery = true)
    List<EventShortInfo> getAllEventsSortedByBeginDate();
}
