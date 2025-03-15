package com.migimnasio.sport.controllers;

import com.migimnasio.sport.dto.PlanDeCarreraDTO;
import com.migimnasio.sport.dto.response.PlanDePagoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPlanDeCarrera {

    @Operation(summary = "Crea un nuevo Plan de Carrera", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Devuelve Plan de Carrera creado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PlanDePagoResponseDTO.class)
                    )
            ),

            @ApiResponse(responseCode = "400",
                    description = "Error de validación de datos.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),

            @ApiResponse(responseCode = "500",
                    description = "Error interno",
                    content = @Content(
                            mediaType = "application/json"
                    )
            )
    })
    public ResponseEntity<?> crearPlanDeCarrera(@RequestBody PlanDeCarreraDTO planDeCarreraDTO);
}
