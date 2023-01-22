package mimuw.backend.repository;

import mimuw.backend.entity.PromoMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoMessageRepository extends JpaRepository<PromoMessage, Long> {
}
