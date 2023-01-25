package mimuw.backend.controller;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.Graphics;
import mimuw.backend.service.GraphicsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/graphics")
public class GraphicsController {
    private GraphicsService graphicsService;

    @PostMapping("/create")
    public ResponseEntity<Graphics> createGraphics(@RequestBody Graphics graphics) {
        Graphics createdGraphics = graphicsService.createGraphics(graphics);
        return new ResponseEntity<>(createdGraphics, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Graphics> updateGraphics(@PathVariable Long id, @RequestBody Graphics graphics) {
        graphics.setId(id);
        Graphics updatedGraphics = graphicsService.updateGraphics(graphics);
        return new ResponseEntity<>(updatedGraphics, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        graphicsService.deleteGraphics(id);
        return new ResponseEntity<>("Graphics successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Graphics> getGraphicsById(@PathVariable Long id) {
        Graphics graphics = graphicsService.getGraphicsById(id);
        return new ResponseEntity<>(graphics, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Graphics>> getAllGraphics() {
        List<Graphics> graphics = graphicsService.getAllGraphics();
        return new ResponseEntity<>(graphics, HttpStatus.OK);
    }
}
