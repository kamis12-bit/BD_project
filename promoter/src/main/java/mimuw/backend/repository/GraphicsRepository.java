package mimuw.backend.repository;

import mimuw.backend.entity.Graphics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GraphicsRepository extends JpaRepository<Graphics, Long> {
    @Query (
        value = 
            "SELECT COUNT(*) " + 
            "FROM promoter_graphics " + 
            "WHERE supervisor = :personId ",
        nativeQuery = true)
    Integer countGraphicsBySupervisor(@Param("personId") Long personId);
}
