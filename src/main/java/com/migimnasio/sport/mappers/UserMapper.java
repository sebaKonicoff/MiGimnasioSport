package com.migimnasio.sport.mappers;

import com.migimnasio.sport.dto.UserDTO;
import com.migimnasio.sport.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
