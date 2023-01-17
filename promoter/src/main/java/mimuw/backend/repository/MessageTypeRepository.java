package mimuw.backend.repository;

import mimuw.backend.entity.MessageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageTypeRepository extends JpaRepository<MessageType, Long> {
}
