package com.migimnasio.sport.controllers;

import com.migimnasio.sport.dto.PlanDeCarreraDTO;
import com.migimnasio.sport.models.PlanDeCarrera;
import com.migimnasio.sport.services.PlanDeCarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plandecarrera")
public class PlanDeCarreraController {

    @Autowired
    PlanDeCarreraService planDeCarreraService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> crearPlanDeCarrera(@RequestBody PlanDeCarreraDTO planDeCarreraDTO){
        PlanDeCarrera response = planDeCarreraService.crearPlanDeCarrera(planDeCarreraDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
