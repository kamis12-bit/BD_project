package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.MessageType;
import mimuw.backend.repository.MessageTypeRepository;
import mimuw.backend.service.MessageTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageTypeServiceImpl implements MessageTypeService {
    private MessageTypeRepository messageTypeRepository;

    @Override
    public MessageType createMessageType(MessageType messageType) {
        return messageTypeRepository.save(messageType);
    }

    @Override
    public MessageType updateMessageType(MessageType messageType) {
        MessageType messageTypeToUpdate = messageTypeRepository.findById(messageType.getId()).orElseThrow();
        messageTypeToUpdate.setName(messageType.getName());
        messageTypeToUpdate.setColour(messageType.getColour());
        return messageTypeRepository.save(messageTypeToUpdate);
    }

    @Override
    public void deleteMessageType(Long id) {
        messageTypeRepository.deleteById(id);
    }

    @Override
    public MessageType getMessageTypeById(Long id) {
        return messageTypeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<MessageType> getAllMessageTypes() {
        return messageTypeRepository.findAll();
    }
}
