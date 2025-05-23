package medidasBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeasureDTO {

    private Long id;

    private Integer systolicValue;

    private Integer diastolicValue;

    private Integer pulseValue;

    private LocalDateTime measureDate;

    private Long userId;
}