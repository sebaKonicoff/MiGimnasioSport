package com.migimnasio.sport.controllers;

import com.migimnasio.sport.dto.PlanDePagoDTO;
import com.migimnasio.sport.models.PlanDePago;
import com.migimnasio.sport.services.PlanDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/planpago")
public class PlanDePagoController {

    @Autowired
    PlanDePagoService planDePagoService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> crearPlanDePago(@RequestBody PlanDePagoDTO planDePagoDTO){
        //CAMBIAR PARA QUE DEVUELVA UN PLANDEPAGORESPONSEDTO
        PlanDePago response = planDePagoService.crearPlanDePago(planDePagoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
