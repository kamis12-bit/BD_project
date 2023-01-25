package mimuw.backend.repository;

import mimuw.backend.entity.Graphics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphicsRepository extends JpaRepository<Graphics, Long> {
}
