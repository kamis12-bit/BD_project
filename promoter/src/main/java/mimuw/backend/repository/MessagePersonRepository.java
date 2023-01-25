package mimuw.backend.repository;

import mimuw.backend.entity.MessagePerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagePersonRepository extends JpaRepository<MessagePerson, Long> {
}
