package medidasBackend.service;

import medidasBackend.model.dto.MeasureDTO;
import medidasBackend.model.RequestFilters;
import medidasBackend.model.entity.Measure;

import java.util.List;

public interface MeasureService {
    public List<MeasureDTO> getMeasures(RequestFilters filters);
    public Measure registerMeasure(Measure measure);
    public void deleteMeasure(Long id);
}
