package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.MessagePerson;
import mimuw.backend.repository.MessagePersonRepository;
import mimuw.backend.service.MessagePersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessagePersonServiceImpl implements MessagePersonService {
    MessagePersonRepository messagePersonRepository;

    public MessagePerson createMessagePerson(MessagePerson messagePerson) {
        return messagePersonRepository.save(messagePerson);
    }

    public MessagePerson updateMessagePerson(MessagePerson messagePerson) {
        MessagePerson messagePersonToUpdate = messagePersonRepository.findById(messagePerson.getId()).orElseThrow();
        messagePersonToUpdate.setPromoMessage(messagePerson.getPromoMessage());
        messagePersonToUpdate.setPerson(messagePerson.getPerson());
        return messagePersonRepository.save(messagePersonToUpdate);
    }

    public void deleteMessagePerson(Long id) {
        messagePersonRepository.deleteById(id);
    }

    public MessagePerson getMessagePersonById(Long id) {
        return messagePersonRepository.findById(id).orElseThrow();
    }

    public List<MessagePerson> getAllMessagePersons() {
        return messagePersonRepository.findAll();
    }
}
