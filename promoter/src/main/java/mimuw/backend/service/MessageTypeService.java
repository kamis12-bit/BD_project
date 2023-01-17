package mimuw.backend.service;

import mimuw.backend.entity.MessageType;
import java.util.List;

public interface MessageTypeService {
    MessageType createMessageType(MessageType messageType);

    MessageType updateMessageType(MessageType messageType);

    void deleteMessageType(Long id);

    MessageType getMessageTypeById(Long id);

    List<MessageType> getAllMessageTypes();
}