package mimuw.backend.controller;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.MessageType;
import mimuw.backend.service.MessageTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/message-type")
public class MessageTypeController {
    private MessageTypeService messageTypeService;

    @PostMapping("/create")
    public ResponseEntity<MessageType> createMessageType(@RequestBody MessageType event) {
        MessageType createdMessageType = messageTypeService.createMessageType(event);
        return new ResponseEntity<>(createdMessageType, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MessageType> updateMessageType(@PathVariable Long id, @RequestBody MessageType messageType) {
        messageType.setId(id);
        MessageType updatedMessageType = messageTypeService.updateMessageType(messageType);
        return new ResponseEntity<>(updatedMessageType, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        messageTypeService.deleteMessageType(id);
        return new ResponseEntity<>("Event successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MessageType> getMessageTypeById(@PathVariable Long id) {
        MessageType messageType = messageTypeService.getMessageTypeById(id);
        return new ResponseEntity<>(messageType, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MessageType>> getAllMessageTypes() {
        List<MessageType> messageTypes = messageTypeService.getAllMessageTypes();
        return new ResponseEntity<>(messageTypes, HttpStatus.OK);
    }
}
