package mitensionbackend.controller;

import lombok.RequiredArgsConstructor;
import mitensionbackend.model.dto.MeasureDTO;
import mitensionbackend.model.RequestFilters;
import mitensionbackend.model.entity.Measure;
import mitensionbackend.mapper.MeasureMapper;
import mitensionbackend.service.MeasureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/measure")
@RequiredArgsConstructor
public class MeasureController {

    private final MeasureService measureService;
    private final MeasureMapper measureMapper;


    @GetMapping
    public List<MeasureDTO> getMeasures(@RequestBody RequestFilters filters) {
        return measureService.getMeasures(filters);
    }

    @PostMapping
    public ResponseEntity<MeasureDTO> registerMeasure(@RequestBody MeasureDTO dto) {
        Measure created = measureService.registerMeasure(measureMapper.toEntity(dto));
        return ResponseEntity.ok(measureMapper.toDto(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasure(@PathVariable Long id) {
        measureService.deleteMeasure(id);
        return ResponseEntity.noContent().build();
    }

}
