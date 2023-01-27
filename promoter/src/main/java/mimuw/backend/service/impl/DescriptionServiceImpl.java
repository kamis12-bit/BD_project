package mimuw.backend.service.impl;

import lombok.AllArgsConstructor;
import mimuw.backend.entity.Description;
import mimuw.backend.repository.DescriptionRepository;
import mimuw.backend.service.DescriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DescriptionServiceImpl implements DescriptionService {
    DescriptionRepository descriptionRepository;
    
    @Override
    public Description createDescription(Description description) {
        return descriptionRepository.save(description);
    }

    @Override
    public Description updateDescription(Description description) {
        Description descriptionToUpdate = descriptionRepository.findById(description.getId()).orElseThrow();
        descriptionToUpdate.setState(description.getState());
        descriptionToUpdate.setReason(description.getReason());
        descriptionToUpdate.setDescriptionContent(description.getDescriptionContent());
        descriptionToUpdate.setSupervisor(description.getSupervisor());
        return descriptionRepository.save(descriptionToUpdate);
    }

    @Override
    public void deleteDescription(Long id) {
        descriptionRepository.deleteById(id);
    }

    @Override
    public Description getDescriptionById(Long id) {
        return descriptionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Description> getAllDescriptions() {
        return descriptionRepository.findAll();
    }

    @Override
    public Integer countDescriptionsBySupervisor(Long personId) {
        return descriptionRepository.countDescriptionsBySupervisor(personId);
    }

    @Override
    public Description duplicateDescription(Long id) {
        Description description = getDescriptionById(id);
        return createDescription(new Description(description));
    }
}
