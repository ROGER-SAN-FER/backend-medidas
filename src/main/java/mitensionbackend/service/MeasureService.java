package mitensionbackend.service;

import mitensionbackend.model.dto.MeasureDTO;
import mitensionbackend.model.RequestFilters;
import mitensionbackend.model.entity.Measure;

import java.util.List;

public interface MeasureService {
    public List<MeasureDTO> getMeasures(RequestFilters filters);
    public Measure registerMeasure(Measure measure);
    public void deleteMeasure(Long id);
}
