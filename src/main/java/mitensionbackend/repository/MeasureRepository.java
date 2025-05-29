package mitensionbackend.repository;

import mitensionbackend.model.entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long>, JpaSpecificationExecutor<Measure> {
}
