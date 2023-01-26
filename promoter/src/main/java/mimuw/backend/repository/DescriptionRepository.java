package mimuw.backend.repository;

import mimuw.backend.entity.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DescriptionRepository extends JpaRepository<Description, Long> {
    @Query (
        value = 
            "SELECT COUNT(*) " + 
            "FROM promoter_description " + 
            "WHERE supervisor = :personId ",
        nativeQuery = true)
    Integer countDescriptionsBySupervisor(@Param("personId") Long personId);
}
