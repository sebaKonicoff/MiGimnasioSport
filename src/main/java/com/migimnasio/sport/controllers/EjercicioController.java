package com.migimnasio.sport.controllers;

import com.migimnasio.sport.models.Ejercicio;
import com.migimnasio.sport.services.EjercicioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {

    @Autowired
    EjercicioService ejercicioService;

    @GetMapping
    @Operation(summary = "Ejercicios", description = "Busqueda completa de maquinas")
    public List<Ejercicio> getAllEjercicios(){
        return ejercicioService.getAllEjercicios();
    }
}
