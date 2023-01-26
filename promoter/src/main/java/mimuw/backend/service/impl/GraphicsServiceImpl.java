package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.Graphics;
import mimuw.backend.repository.GraphicsRepository;
import mimuw.backend.service.GraphicsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GraphicsServiceImpl implements GraphicsService {
    GraphicsRepository graphicsRepository;

    @Override
    public Graphics createGraphics(Graphics graphics) {
        return graphicsRepository.save(graphics);
    }

    @Override
    public Graphics updateGraphics(Graphics graphics) {
        Graphics graphicsToUpdate = graphicsRepository.findById(graphics.getId()).orElseThrow();
        graphicsToUpdate.setState(graphics.getState());
        graphicsToUpdate.setReason(graphics.getReason());
        graphicsToUpdate.setGraphicsContent(graphics.getGraphicsContent());
        graphicsToUpdate.setSupervisor(graphics.getSupervisor());
        return graphicsRepository.save(graphicsToUpdate);
    }

    @Override
    public void deleteGraphics(Long id) {
        graphicsRepository.deleteById(id);
    }

    @Override
    public Graphics getGraphicsById(Long id) {
        return graphicsRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Graphics> getAllGraphics() {
        return graphicsRepository.findAll();
    }

    @Override
    public Integer countGraphicsBySupervisor(Long personId) {
        return graphicsRepository.countGraphicsBySupervisor(personId);
    }
}
