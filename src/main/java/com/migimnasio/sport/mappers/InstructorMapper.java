package com.migimnasio.sport.mappers;

import com.migimnasio.sport.dto.InstructorDTO;
import com.migimnasio.sport.models.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface InstructorMapper {

    @Mapping(target = "userDTO", source = "user")
    InstructorDTO toDTO(Instructor instructor);

    @Mapping(target = "user", source = "userDTO")
    Instructor toEntity(InstructorDTO instructorDTO);
}
