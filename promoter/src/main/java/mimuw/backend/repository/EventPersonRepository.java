package mimuw.backend.repository;

import mimuw.backend.entity.EventPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPersonRepository extends JpaRepository<EventPerson, Long> {
}
