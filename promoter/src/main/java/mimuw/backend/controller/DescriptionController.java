package mimuw.backend.controller;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.Description;
import mimuw.backend.service.DescriptionService;
import mimuw.backend.service.PromoMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/description")
public class DescriptionController {
    private DescriptionService descriptionService;
    private PromoMessageService promoMessageService;

    @PostMapping("/create")
    public ResponseEntity<Description> createDescription(@RequestBody Description description) {
        Description createdDescription = descriptionService.createDescription(description);
        return new ResponseEntity<>(createdDescription, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Description> updateDescription(@PathVariable Long id, @RequestBody Description description) {
        description.setId(id);
        Description updatedDescription = descriptionService.updateDescription(description);
        return new ResponseEntity<>(updatedDescription, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDescription(@PathVariable Long id) {
        promoMessageService.deleteDescriptionFromPromoMessage(id);
        descriptionService.deleteDescription(id);
        return new ResponseEntity<>("Description successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Description> getDescriptionById(@PathVariable Long id) {
        Description description = descriptionService.getDescriptionById(id);
        return new ResponseEntity<>(description, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Description>> getAllDescriptions() {
        List<Description> descriptions = descriptionService.getAllDescriptions();
        return new ResponseEntity<>(descriptions, HttpStatus.OK);
    }

    @GetMapping("/duplicate/{id}")
    public ResponseEntity<Description> duplicateDescription(@PathVariable Long id) {
        Description newDescription = descriptionService.duplicateDescription(id);
        return new ResponseEntity<>(newDescription, HttpStatus.CREATED);
    }
}
