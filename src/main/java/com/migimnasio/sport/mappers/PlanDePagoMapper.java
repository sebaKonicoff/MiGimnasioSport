package com.migimnasio.sport.mappers;

import com.migimnasio.sport.dto.response.PlanDePagoResponseDTO;
import com.migimnasio.sport.models.PlanDePago;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanDePagoMapper {

    PlanDePagoResponseDTO toResponseDTO(PlanDePago planDePago);
}
