package com.migimnasio.sport.controllers;

import com.migimnasio.sport.dto.EjercicioMaquinaDTO;
import com.migimnasio.sport.models.Maquina;
import com.migimnasio.sport.services.EjerMaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ejermaq")
public class EjerMaqController {

    @Autowired
    EjerMaqService ejerMaqService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    private ResponseEntity<String> addEjercicioToMaquina(
            @RequestBody EjercicioMaquinaDTO ejercicioMaquinaDTO){
        ejerMaqService.addEjercicioToMaquina(ejercicioMaquinaDTO.getIdMaquina(), ejercicioMaquinaDTO.getIdEjercicio());
        return ResponseEntity.ok("Insercion exitosa");
    }
}
