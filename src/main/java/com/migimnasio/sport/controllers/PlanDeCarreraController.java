package com.migimnasio.sport.controllers;

import com.migimnasio.sport.dto.PlanDeCarreraDTO;
import com.migimnasio.sport.dto.response.PlanDeCarreraResponseDTO;
import com.migimnasio.sport.dto.response.PlanDePagoResponseDTO;
import com.migimnasio.sport.enums.PlanDeCarreraEstado;
import com.migimnasio.sport.models.PlanDeCarrera;
import com.migimnasio.sport.services.PlanDeCarreraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plandecarrera")
public class PlanDeCarreraController implements IPlanDeCarrera{

    @Autowired
    PlanDeCarreraService planDeCarreraService;

    private static final Logger log = LoggerFactory.getLogger(PlanDeCarreraController.class);

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> crearPlanDeCarrera(@RequestBody PlanDeCarreraDTO planDeCarreraDTO){
        PlanDeCarreraResponseDTO response = planDeCarreraService.crearPlanDeCarrera(planDeCarreraDTO);
        log.info("Plan de carrera creado.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstadoPlanDeCarrera(@PathVariable Long id, @RequestParam PlanDeCarreraEstado planDeCarreraEstado){
        try {
            PlanDeCarrera planDeCarrera = planDeCarreraService.actualizarEstado(id, planDeCarreraEstado);
            return ResponseEntity.status(HttpStatus.OK).body(planDeCarrera);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al actualziar el estado del Plan de carrera");
        }
    }
}
