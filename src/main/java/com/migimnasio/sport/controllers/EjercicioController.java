package com.migimnasio.sport.controllers;

import com.migimnasio.sport.models.Ejercicio;
import com.migimnasio.sport.services.EjercicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {

    @Autowired
    EjercicioService ejercicioService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> crearEjercicio(@RequestBody Ejercicio ejercicio){
        try {
            Ejercicio response = ejercicioService.crearEjercicio(ejercicio);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al intentar crear Ejercicio");
        }
    }

    @GetMapping
    @Operation(summary = "Ejercicios", description = "Busqueda completa de maquinas")
    public List<Ejercicio> getAllEjercicios(){
        return ejercicioService.getAllEjercicios();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Ejercicio> findById(
            @PathVariable
            @Parameter(name = "id", description = "Id de Ejercicio a buscar")
            Long id){
        Optional<Ejercicio> ejercicio = ejercicioService.getById(id);
        if(ejercicio.isPresent()){
            return ResponseEntity.ok(ejercicio.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
