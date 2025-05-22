package medidasBackend.service;

import medidasBackend.entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasureService {
    public List<Measure> getAllMeasures();
    public Measure registerMeasure(Measure measure);
    public String deleteMeasure(Long id);
}
