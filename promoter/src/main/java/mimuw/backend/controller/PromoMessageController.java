package mimuw.backend.controller;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.PromoMessage;
import mimuw.backend.service.DescriptionService;
import mimuw.backend.service.GraphicsService;
import mimuw.backend.service.MessagePersonService;
import mimuw.backend.service.PromoMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/promo-message")
public class PromoMessageController {
    private PromoMessageService promoMessageService;
    private MessagePersonService messagePersonService;
    private GraphicsService graphicsService;
    private DescriptionService descriptionService;

    @PostMapping("/create")
    public ResponseEntity<PromoMessage> createPromoMessage(@RequestBody PromoMessage promoMessage) {
        PromoMessage createdPromoMessage = promoMessageService.createPromoMessage(promoMessage);
        return new ResponseEntity<>(createdPromoMessage, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PromoMessage> updatePromoMessage(@PathVariable Long id, @RequestBody PromoMessage promoMessage) {
        promoMessage.setId(id);
        PromoMessage updatedPromoMessage = promoMessageService.updatePromoMessage(promoMessage);
        return new ResponseEntity<>(updatedPromoMessage, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePromoMessage(@PathVariable Long id) {
        messagePersonService.deleteMessagePersonsByPromoMessage(id);
        PromoMessage deletedPromoMessage = promoMessageService.getPromoMessageById(id);
        if (deletedPromoMessage.getGraphics() != null)
            graphicsService.deleteGraphics(deletedPromoMessage.getGraphics());
        if (deletedPromoMessage.getDescription() != null)
            descriptionService.deleteDescription(deletedPromoMessage.getDescription());

        promoMessageService.deletePromoMessage(id);
        return new ResponseEntity<>("Promo message successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PromoMessage> getPromoMessageById(@PathVariable Long id) {
        PromoMessage promoMessage = promoMessageService.getPromoMessageById(id);
        return new ResponseEntity<>(promoMessage, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PromoMessage>> getAllPromoMessages() {
        List<PromoMessage> promoMessages = promoMessageService.getAllPromoMessages();
        return new ResponseEntity<>(promoMessages, HttpStatus.OK);
    }
}
