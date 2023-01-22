package mimuw.backend.service;

import mimuw.backend.entity.Description;
import java.util.List;

public interface DescriptionService {
    Description createDescription(Description description);

    Description updateDescription(Description description);

    void deleteDescription(Long id);

    Description getDescriptionById(Long id);

    List<Description> getAllDescriptions();
}