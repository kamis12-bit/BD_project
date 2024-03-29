package mimuw.backend.repository;

import mimuw.backend.entity.PromoMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PromoMessageRepository extends JpaRepository<PromoMessage, Long> {
    @Query (
        value = 
            "SELECT COUNT(*) as sum_all " + 
            "FROM promoter_promo_message " + 
            "WHERE event = :eventId ",
        nativeQuery = true)
    Integer countAllPromoMessagesByEvent(@Param("eventId") Long eventId);

    @Query (
        value = 
            "SELECT SUM(published) as sum_published " + 
            "FROM promoter_promo_message " + 
            "WHERE event = :eventId ",
        nativeQuery = true)
    Integer countPublishedPromoMessagesByEvent(@Param("eventId") Long eventId);

    @Query (
        value = 
            "SELECT COUNT(*) " + 
            "FROM promoter_promo_message " + 
            "WHERE has_type = :messageTypeId ",
        nativeQuery = true)
    Integer countPromoMessagesByType(@Param("messageTypeId") Long messageTypeId);

    @Modifying
    @Query (
        value = 
            "DELETE FROM promoter_promo_message " + 
            "WHERE event = :eventId ",
        nativeQuery = true)
    void deletePromoMessagesByEvent(@Param("eventId") Long eventId);

    @Query (
        value =
            "SELECT * " +
            "FROM promoter_promo_message " +
            "WHERE event = :eventId ",
        nativeQuery = true)
    List<PromoMessage> getPromoMessagesByEvent(@Param("eventId") Long eventId);

    @Query (
        value =
            "SELECT * " +
            "FROM promoter_promo_message " +
            "WHERE description = :descriptionId " +
            "FETCH FIRST 1 ROWS ONLY ",
        nativeQuery = true)
    PromoMessage getPromoMessageByDescription(@Param("descriptionId") Long descriptionId);

    @Query (
        value =
            "SELECT * " +
            "FROM promoter_promo_message " +
            "WHERE graphics = :graphicsId " +
            "FETCH FIRST 1 ROWS ONLY ",
        nativeQuery = true)
    PromoMessage getPromoMessageByGraphics(@Param("graphicsId") Long graphicsId);
}
