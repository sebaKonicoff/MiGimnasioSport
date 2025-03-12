package com.migimnasio.sport.controllers;

import com.migimnasio.sport.dto.PlanDeCarreraDTO;
import com.migimnasio.sport.dto.response.PlanDeCarreraResponseDTO;
import com.migimnasio.sport.models.PlanDeCarrera;
import com.migimnasio.sport.services.PlanDeCarreraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(PlanDeCarreraController.class);

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> crearPlanDeCarrera(@RequestBody PlanDeCarreraDTO planDeCarreraDTO){
        PlanDeCarreraResponseDTO response = planDeCarreraService.crearPlanDeCarrera(planDeCarreraDTO);
        log.info("Plan de carrera creado.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
