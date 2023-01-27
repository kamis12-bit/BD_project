package mimuw.backend.repository;

import mimuw.backend.entity.MessagePerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessagePersonRepository extends JpaRepository<MessagePerson, Long> {
    @Query (
        value = 
            "SELECT COUNT(*) " + 
            "FROM promoter_message_person " + 
            "WHERE person = :personId ",
        nativeQuery = true)
    Integer countMessagePersonsByPerson(@Param("personId") Long personId);

    @Modifying
    @Query (
        value = 
            "DELETE FROM promoter_message_person " + 
            "WHERE promo_message = :promoMessageId ",
        nativeQuery = true)
    void deleteMessagePersonsByPromoMessage(@Param("promoMessageId") Long promoMessageId);

    @Query (
        value =
            "SELECT person " +
            "FROM promoter_message_person " + 
            "WHERE promo_message = :promoMessageId ",
        nativeQuery = true)
    List<Long> getPersonsIdByPromoMessage(@Param("promoMessageId") Long promoMessageId);
}
