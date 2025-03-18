package com.migimnasio.sport.controllers;

import com.migimnasio.sport.dto.PlanDePagoDTO;
import com.migimnasio.sport.dto.response.PlanDePagoResponseDTO;
import com.migimnasio.sport.enums.PlanPagoEstado;
import com.migimnasio.sport.services.PlanDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planpago")
public class PlanDePagoController {

    @Autowired
    PlanDePagoService planDePagoService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> crearPlanDePago(@RequestBody PlanDePagoDTO planDePagoDTO){
        PlanDePagoResponseDTO response = planDePagoService.crearPlanDePago(planDePagoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstadoPlanPago(@PathVariable Long id, @RequestParam PlanPagoEstado nuevoEstado){
        PlanDePagoResponseDTO response = planDePagoService.actualizarPlanDePago(id,nuevoEstado);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
