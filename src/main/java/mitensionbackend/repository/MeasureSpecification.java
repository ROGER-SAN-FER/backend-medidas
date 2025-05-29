package mitensionbackend.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import mitensionbackend.model.RequestFilters;
import mitensionbackend.model.entity.Measure;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@AllArgsConstructor
@RequiredArgsConstructor
public class MeasureSpecification implements Specification<Measure> {

    private LocalDate fromDate;
    private LocalDate toDate;

    public MeasureSpecification(RequestFilters filters) {
        this.fromDate = filters.getFromDate() != null ? filters.getFromDate() : null ; // Asume que filters.getFromDate() puede ser null
        this.toDate = filters.getToDate() != null ? filters.getFromDate() : null ;     // Asume que filters.getToDate() puede ser null
    }

    @Override
    public Predicate toPredicate(@NonNull Root<Measure> root, @NonNull CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction(); // Inicia con un predicado "true"

        if (fromDate != null){
            // Convertir fromDate (LocalDate) a LocalDateTime al inicio del día (00:00:00)
            LocalDateTime startOfDay = fromDate.atStartOfDay();
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("measureDate"), startOfDay));
        }

        if (toDate != null){
            // Convertir toDate (LocalDate) a LocalDateTime al final del día (23:59:59.999...)
            // LocalTime.MAX representa 23:59:59.999999999
            LocalDateTime endOfDay = toDate.atTime(LocalTime.MAX);
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("measureDate"), endOfDay));
        }

        return predicate;
    }
}
