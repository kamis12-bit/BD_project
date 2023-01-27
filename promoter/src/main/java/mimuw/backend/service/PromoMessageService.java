package mimuw.backend.service;

import mimuw.backend.entity.PromoMessage;
import java.util.List;

public interface PromoMessageService {

    PromoMessage createPromoMessage(PromoMessage promoMessage);

    PromoMessage updatePromoMessage(PromoMessage promoMessage);

    void deletePromoMessage(Long id);

    void deletePromoMessagesByEvent(Long eventId);

    PromoMessage getPromoMessageById(Long id);

    List<PromoMessage> getAllPromoMessages();

    Integer isPromoMessagePublishedByEvent(Long eventId);

    Integer countPromoMessagesByType(Long messageTypeId);

    PromoMessage duplicatePromoMessage(Long id);
}
