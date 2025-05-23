package medidasBackend.mapper;

import medidasBackend.dto.UserDTO;
import medidasBackend.dto.MeasureDTO;
import medidasBackend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = { MeasureMapper.class }
)
public interface UserMapper {

    @Mapping(source = "measures", target = "measures")
    UserDTO toDto(User entity);

    @Mapping(source = "measures", target = "measures")
    @Mapping(source = "password", target = "password")
    User toEntity(UserDTO dto);

    /** List conversions */
    List<UserDTO> toDtoList(List<User> entities);
    List<User> toEntityList(List<UserDTO> dtos);
}