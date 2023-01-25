package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.PromoMessage;
import mimuw.backend.repository.PromoMessageRepository;
import mimuw.backend.service.PromoMessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PromoMessageImpl implements PromoMessageService {
    private PromoMessageRepository promoMessageRepository;

    @Override
    public PromoMessage createPromoMessage(PromoMessage promoMessage) {
        return promoMessageRepository.save(promoMessage);
    }

    @Override
    public PromoMessage updatePromoMessage(PromoMessage promoMessage) {
        PromoMessage promoMessageToUpdate = promoMessageRepository.findById(promoMessage.getId()).orElseThrow();
        promoMessageToUpdate.setName(promoMessage.getName());
        promoMessageToUpdate.setPublicationDate(promoMessage.getPublicationDate());
        promoMessageToUpdate.setPublished(promoMessage.getPublished());
        promoMessageToUpdate.setEvent(promoMessage.getEvent());
        promoMessageToUpdate.setGraphics(promoMessage.getGraphics());
        promoMessageToUpdate.setDescription(promoMessage.getDescription());
        promoMessageToUpdate.setHasType(promoMessage.getHasType());
        return promoMessageRepository.save(promoMessageToUpdate);
    }

    @Override
    public void deletePromoMessage(Long id) {
        promoMessageRepository.deleteById(id);
    }

    @Override
    public PromoMessage getPromoMessageById(Long id) {
        return promoMessageRepository.findById(id).orElseThrow();
    }

    @Override
    public List<PromoMessage> getAllPromoMessages() {
        return promoMessageRepository.findAll();
    }

    @Override
    public Integer isPromoMessagePublishedByEvent(Long eventId) {
        Integer sumAll = promoMessageRepository.countAllPromoMessagesByEvent(eventId);
        Integer sumPublished = promoMessageRepository.countPublishedPromoMessagesByEvent(eventId);
        return sumAll == sumPublished ? 1 : 0;
    }
}
