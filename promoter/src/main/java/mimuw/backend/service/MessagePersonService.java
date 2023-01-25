package mimuw.backend.service;

import mimuw.backend.entity.MessagePerson;
import java.util.List;

public interface MessagePersonService {
    MessagePerson createMessagePerson(MessagePerson messagePerson);

    MessagePerson updateMessagePerson(MessagePerson messagePerson);

    void deleteMessagePerson(Long id);

    MessagePerson getMessagePersonById(Long id);

    List<MessagePerson> getAllMessagePersons();
}
