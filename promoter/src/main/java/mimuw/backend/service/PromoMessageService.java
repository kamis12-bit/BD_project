package mimuw.backend.service;

import mimuw.backend.entity.PromoMessage;
import java.util.List;

public interface PromoMessageService {

    PromoMessage createPromoMessage(PromoMessage promoMessage);

    PromoMessage updatePromoMessage(PromoMessage promoMessage);

    void deletePromoMessage(Long id);

    PromoMessage getPromoMessageById(Long id);

    List<PromoMessage> getAllPromoMessages();

    Integer isPromoMessagePublishedByEvent(Long eventId);
}
