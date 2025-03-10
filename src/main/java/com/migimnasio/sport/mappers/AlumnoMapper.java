package com.migimnasio.sport.mappers;

import com.migimnasio.sport.dto.AlumnoDTO;
import com.migimnasio.sport.models.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AlumnoMapper {

    @Mapping(target = "userDTO", source = "user") // Asegura que usuario → userDTO
    AlumnoDTO toDTO(Alumno alumno);

    @Mapping(source = "userDTO", target = "user") // Si es bidireccional
    Alumno toEntity(AlumnoDTO alumnoDTO);
}
