package mitensionbackend.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MEASURE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Measure {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_MEASURE")
    @SequenceGenerator(name = "generator_MEASURE", sequenceName = "MEASURE_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SYSTOLIC_VALUE")
    private Integer systolicValue;

    @Column(name = "DIASTOLIC_VALUE")
    private Integer diastolicValue;

    @Column(name = "PULSE_VALUE")
    private Integer pulseValue;

    @Column(name = "MEASURE_DATE")
    private LocalDateTime measureDate;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonBackReference
    private User user;
}