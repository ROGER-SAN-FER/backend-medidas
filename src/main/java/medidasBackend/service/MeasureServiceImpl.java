package medidasBackend.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import medidasBackend.model.dto.MeasureDTO;
import medidasBackend.model.RequestFilters;
import medidasBackend.model.entity.Measure;
import medidasBackend.mapper.MeasureMapper;
import medidasBackend.repository.MeasureRepository;
import medidasBackend.repository.MeasureSpecification;
import medidasBackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MeasureServiceImpl implements MeasureService {

    private final MeasureRepository measureRepository;
    private final UserRepository userRepository;
    private final MeasureMapper measureMapper;

    public MeasureServiceImpl(MeasureRepository measureRepository, UserRepository userRepository, MeasureMapper measureMapper) {
        this.measureRepository = measureRepository;
        this.userRepository = userRepository;
        this.measureMapper = measureMapper;
    }

    @Override
    public List<MeasureDTO> getMeasures(RequestFilters filters){
        List<Measure> measureList = measureRepository.findAll(new MeasureSpecification(filters));

        return measureMapper.toDtos(measureList);
    }

    @Override
    public Measure registerMeasure(Measure measure){
        Long userId = measure.getUser() != null ? measure.getUser().getId() : null;

        if (userId == null || !userRepository.existsById(userId)) {
            throw new EntityNotFoundException("Id de usuario no existe: " + userId);
        }

        return measureRepository.save(measure);
    }

    @Override
    public void deleteMeasure(Long id){
        Measure existente = measureRepository.findById(id).orElse(null);
        if(existente != null){
            measureRepository.deleteById(id);
        } else {
        }
    }
}
