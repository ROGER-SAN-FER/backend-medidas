package medidasBackend.mapper;

import medidasBackend.dto.MeasureDTO;
import medidasBackend.entity.Measure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MeasureMapper {

    /** Entity → DTO */
    @Mapping(source = "user.id", target = "userId")
    MeasureDTO toDto(Measure entity);

    /** DTO → Entity */
    @Mapping(source = "userId", target = "user.id")
    Measure toEntity(MeasureDTO dto);
}
