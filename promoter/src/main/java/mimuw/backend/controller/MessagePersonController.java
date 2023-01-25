package mimuw.backend.controller;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.MessagePerson;
import mimuw.backend.service.MessagePersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/message-person")
public class MessagePersonController {
    private MessagePersonService messagePersonService;

    @PostMapping("/create")
    public ResponseEntity<MessagePerson> createMessagePerson(@RequestBody MessagePerson messagePerson) {
        MessagePerson createdMessagePerson = messagePersonService.createMessagePerson(messagePerson);
        return new ResponseEntity<>(createdMessagePerson, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MessagePerson> updateMessagePerson(@PathVariable Long id, @RequestBody MessagePerson messagePerson) {
        messagePerson.setId(id);
        MessagePerson updatedMessagePerson = messagePersonService.updateMessagePerson(messagePerson);
        return new ResponseEntity<>(updatedMessagePerson, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMessagePerson(@PathVariable Long id) {
        messagePersonService.deleteMessagePerson(id);
        return new ResponseEntity<>("MessagePerson successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MessagePerson> getMessagePersonById(@PathVariable Long id) {
        MessagePerson messagePerson = messagePersonService.getMessagePersonById(id);
        return new ResponseEntity<>(messagePerson, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MessagePerson>> getAllMessagePersons() {
        List<MessagePerson> messagePeople = messagePersonService.getAllMessagePersons();
        return new ResponseEntity<>(messagePeople, HttpStatus.OK);
    }
}
