package medidasBackend.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import medidasBackend.entity.Measure;
import medidasBackend.repository.MeasureRepository;
import medidasBackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MeasureServiceImpl implements MeasureService {

    private final MeasureRepository measureRepository;
    private final UserRepository userRepository;
    public MeasureServiceImpl(MeasureRepository measureRepository, UserRepository userRepository) {
        this.measureRepository = measureRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Measure> getAllMeasures(){
        return measureRepository.findAll();
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
    public String deleteMeasure(Long id){
        Measure existente = measureRepository.findById(id).orElse(null);
        if(existente != null){
            measureRepository.deleteById(id);
            return "Measure con id: " + id + " eliminado.";
        } else {
            return "No existe el measure con id: " + id;
        }
    }
}
