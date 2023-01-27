package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.Description;
import mimuw.backend.entity.Graphics;
import mimuw.backend.entity.MessagePerson;
import mimuw.backend.entity.PromoMessage;
import mimuw.backend.repository.DescriptionRepository;
import mimuw.backend.repository.GraphicsRepository;
import mimuw.backend.repository.MessagePersonRepository;
import mimuw.backend.repository.PromoMessageRepository;
import mimuw.backend.service.PromoMessageService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PromoMessageServiceImpl implements PromoMessageService {
    private PromoMessageRepository promoMessageRepository;
    private DescriptionRepository descriptionRepository;
    private GraphicsRepository graphicsRepository;
    private MessagePersonRepository messagePersonRepository;

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
    @Transactional
    public void deletePromoMessagesByEvent(Long eventId) {
        promoMessageRepository.deletePromoMessagesByEvent(eventId);
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

    @Override
    public Integer countPromoMessagesByType(Long messageTypeId) {
        return promoMessageRepository.countPromoMessagesByType(messageTypeId);
    }

    @Override
    public PromoMessage duplicatePromoMessage(Long id) {
        PromoMessage newPromoMessage = createPromoMessage(getPromoMessageById(id));
        Long newId = newPromoMessage.getId();
        if (newPromoMessage.getDescription() != null) {
            System.out.println("Description: " + newPromoMessage.getDescription());
            Description oldDescription = descriptionRepository.findById(newPromoMessage.getDescription()).orElseThrow();
            Description newDescription = descriptionRepository.save(oldDescription);
            newPromoMessage.setDescription(newDescription.getId());
        }
        if (newPromoMessage.getGraphics() != null) {
            System.out.println("Graphics: " + newPromoMessage.getGraphics());
            Graphics oldGraphics = graphicsRepository.findById(newPromoMessage.getGraphics()).orElseThrow();
            Graphics newGraphics = graphicsRepository.save(oldGraphics);
            newPromoMessage.setGraphics(newGraphics.getId());
        }
        List<Long> personsId = messagePersonRepository.getPersonsIdByPromoMessage(id);
        for (Long personId: personsId){
            MessagePerson messagePerson = new MessagePerson();
            messagePerson.setPerson(personId);
            messagePerson.setPromoMessage(newId);
            messagePersonRepository.save(messagePerson);
        }
        return newPromoMessage;
    }
}
