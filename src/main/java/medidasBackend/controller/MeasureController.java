package medidasBackend.controller;

import medidasBackend.entity.Measure;
import medidasBackend.service.MeasureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/measure")
public class MeasureController {

    public final MeasureService measureService;
    public MeasureController(MeasureService measureService) {
        this.measureService = measureService;
    }

    @GetMapping
    public List<Measure> getAllMeasures() {
        return measureService.getAllMeasures();
    }

    @PostMapping
    public Measure registerMeasure(@RequestBody Measure measure) {
        return measureService.registerMeasure(measure);
    }

    @DeleteMapping("/{id}")
    public String deleteMeasure(@PathVariable Long id) {
        return measureService.deleteMeasure(id);
    }

}
