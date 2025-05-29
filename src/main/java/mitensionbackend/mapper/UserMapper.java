package mitensionbackend.mapper;

import mitensionbackend.model.dto.UserDTO;
import mitensionbackend.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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