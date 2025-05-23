package medidasBackend.controller;

import lombok.RequiredArgsConstructor;
import medidasBackend.dto.MeasureDTO;
import medidasBackend.entity.Measure;
import medidasBackend.mapper.MeasureMapper;
import medidasBackend.service.MeasureService;
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
    public List<MeasureDTO> getAllMeasures() {
        List<Measure> measures = measureService.getAllMeasures();
        return measures.stream()
                .map(measureMapper::toDto)
                .toList();
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
