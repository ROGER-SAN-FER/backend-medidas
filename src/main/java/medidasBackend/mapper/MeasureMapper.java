package medidasBackend.mapper;

import medidasBackend.model.dto.MeasureDTO;
import medidasBackend.model.entity.Measure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MeasureMapper {

    /** Entity → DTO */
    @Mapping(source = "user.id", target = "userId")
    MeasureDTO toDto(Measure entity);

    /** DTO → Entity */
    @Mapping(source = "userId", target = "user.id")
    Measure toEntity(MeasureDTO dto);

    List<MeasureDTO> toDtos(List<Measure> entities);

}
