package com.migimnasio.sport.mappers;

import com.migimnasio.sport.dto.AlumnoDTO;
import com.migimnasio.sport.models.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {

    @Mappings({
            @Mapping(target = "usuario", ignore = true) // Opcional si estás manejando UsuarioDTO correctamente
    })
    AlumnoDTO toDTO(Alumno alumno);

    Alumno toEntity(AlumnoDTO alumnoDTO);
}
