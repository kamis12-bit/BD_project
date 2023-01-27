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
import java.util.Objects;

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
        return Objects.equals(sumAll, sumPublished) ? 1 : 0;
    }

    @Override
    public Integer countPromoMessagesByType(Long messageTypeId) {
        return promoMessageRepository.countPromoMessagesByType(messageTypeId);
    }

    private PromoMessage duplicateDescriptionAndGraphics(PromoMessage promoMessage){
        PromoMessage newPromoMessage = new PromoMessage(promoMessage);
        if (promoMessage.getDescription() != null) {
            System.out.println("Description: " + promoMessage.getDescription());
            Description oldDescription = descriptionRepository.findById(promoMessage.getDescription()).orElseThrow();
            Description newDescription = descriptionRepository.save(new Description(oldDescription));
            newPromoMessage.setDescription(newDescription.getId());
        }

        if (promoMessage.getGraphics() != null) {
            System.out.println("Graphics: " + promoMessage.getGraphics());
            Graphics oldGraphics = graphicsRepository.findById(promoMessage.getGraphics()).orElseThrow();
            Graphics newGraphics = graphicsRepository.save(new Graphics(oldGraphics));
            newPromoMessage.setGraphics(newGraphics.getId());
        }
        return newPromoMessage;
    }

    private void duplicateMessagePersons(Long oldId, Long newId){
        List<Long> personsId = messagePersonRepository.getPersonsIdByPromoMessage(oldId);
        for (Long personId: personsId){
            MessagePerson messagePerson = new MessagePerson();
            messagePerson.setPerson(personId);
            messagePerson.setPromoMessage(newId);
            messagePersonRepository.save(messagePerson);
        }
    }

    @Override
    public PromoMessage duplicatePromoMessage(Long id) {
        PromoMessage promoMessage = getPromoMessageById(id);
        PromoMessage newPromoMessage = duplicateDescriptionAndGraphics(promoMessage);

        PromoMessage createdPromoMessage = promoMessageRepository.save(newPromoMessage);
        Long newId = createdPromoMessage.getId();
        duplicateMessagePersons(id, newId);

        return createdPromoMessage;
    }

    @Override
    public void duplicatePromoMessagesByEvent(Long oldEventId, Long newEventId) {
        List<PromoMessage> promoMessages = promoMessageRepository.getPromoMessagesByEvent(oldEventId);
        for (PromoMessage promoMessage: promoMessages){
            PromoMessage newPromoMessage = new PromoMessage(promoMessage);
            newPromoMessage.setEvent(newEventId);
            PromoMessage changedPromoMessage = duplicateDescriptionAndGraphics(newPromoMessage);
            PromoMessage createdPromoMessage = promoMessageRepository.save(changedPromoMessage);
            Long newId = createdPromoMessage.getId();
            duplicateMessagePersons(promoMessage.getId(), newId);
        }
    }

    @Override
    public PromoMessage deleteDescriptionFromPromoMessage(Long descriptionId) {
        PromoMessage promoMessage = promoMessageRepository.getPromoMessageByDescription(descriptionId);
        promoMessage.setDescription(null);
        return promoMessageRepository.save(promoMessage);
    }

    @Override
    public PromoMessage deleteGraphicsFromPromoMessage(Long graphicsId) {
        PromoMessage promoMessage = promoMessageRepository.getPromoMessageByGraphics(graphicsId);
        promoMessage.setGraphics(null);
        return promoMessageRepository.save(promoMessage);
    }
}
