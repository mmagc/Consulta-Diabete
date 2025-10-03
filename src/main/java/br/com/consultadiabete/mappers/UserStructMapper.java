package br.com.consultadiabete.mappers;

import br.com.consultadiabete.dto.users.CreateUserDto;
import br.com.consultadiabete.dto.users.UserResponseDTO;
import br.com.consultadiabete.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserStructMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "glucoseData", ignore = true)
    User toEntity(CreateUserDto dto);

    UserResponseDTO toResponseDTO(User entity);

}
