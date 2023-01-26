package mimuw.backend.service;

import mimuw.backend.entity.Graphics;
import java.util.List;

public interface GraphicsService {
    Graphics createGraphics(Graphics graphics);

    Graphics updateGraphics(Graphics graphics);

    void deleteGraphics(Long id);

    Graphics getGraphicsById(Long id);

    List<Graphics> getAllGraphics();

    Integer countGraphicsBySupervisor(Long personId);
}
