package com.migimnasio.sport.mappers;

import com.migimnasio.sport.dto.PlanDeCarreraDTO;
import com.migimnasio.sport.models.PlanDeCarrera;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanDeCarreraMapper {

    PlanDeCarreraDTO toDTO(PlanDeCarrera planDeCarrera);

    PlanDeCarrera toEntity(PlanDeCarreraDTO planDeCarreraDTO);
}
