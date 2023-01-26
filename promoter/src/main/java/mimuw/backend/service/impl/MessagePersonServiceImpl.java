package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.MessagePerson;
import mimuw.backend.repository.MessagePersonRepository;
import mimuw.backend.service.MessagePersonService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MessagePersonServiceImpl implements MessagePersonService {
    MessagePersonRepository messagePersonRepository;

    @Override
    public MessagePerson createMessagePerson(MessagePerson messagePerson) {
        return messagePersonRepository.save(messagePerson);
    }

    @Override
    public MessagePerson updateMessagePerson(MessagePerson messagePerson) {
        MessagePerson messagePersonToUpdate = messagePersonRepository.findById(messagePerson.getId()).orElseThrow();
        messagePersonToUpdate.setPromoMessage(messagePerson.getPromoMessage());
        messagePersonToUpdate.setPerson(messagePerson.getPerson());
        return messagePersonRepository.save(messagePersonToUpdate);
    }

    @Override
    public void deleteMessagePerson(Long id) {
        messagePersonRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteMessagePersonsByPromoMessage(Long promoMessageId) {
        messagePersonRepository.deleteMessagePersonsByPromoMessage(promoMessageId);
    }

    @Override
    public MessagePerson getMessagePersonById(Long id) {
        return messagePersonRepository.findById(id).orElseThrow();
    }

    @Override
    public List<MessagePerson> getAllMessagePersons() {
        return messagePersonRepository.findAll();
    }

    @Override
    public Integer countMessagePersonsByPerson(Long personId) {
        return messagePersonRepository.countMessagePersonsByPerson(personId);
    }
}
