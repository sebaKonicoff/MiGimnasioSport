package com.migimnasio.sport.controllers;

import com.migimnasio.sport.enums.MaquinaEstado;
import com.migimnasio.sport.models.Maquina;
import com.migimnasio.sport.services.MaquinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maquinas")
public class MaquinaController {

    @Autowired
    MaquinaService maquinaService;

    @GetMapping
    @Operation(summary = "Maquinas", description = "Busqueda completa de maquinas")
    public List<Maquina> getAllMaquinas() {
        return maquinaService.getAllMaquinas();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Maquina> findById(
            @PathVariable
            @Parameter(name = "id", description = "Id de máquina a buscar", example = "1")
            Long id) {
        Optional<Maquina> maquina = maquinaService.getById(id);
        if (maquina.isPresent()) {
            return ResponseEntity.ok(maquina.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    private ResponseEntity<Maquina> createMaquina(@Valid @RequestBody Maquina newMaquina, UriComponentsBuilder ucb) {
        Maquina maquina = maquinaService.createMaquina(newMaquina);
        URI uriMaquina = ucb.path("/api/maquinas/{id}").buildAndExpand(maquina.getIdMaquina()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(uriMaquina).body(maquina);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstadoMaquina(@PathVariable long id, @Valid @RequestBody MaquinaEstado nuevoEstado){
        try{
            Maquina maquina = maquinaService.actualizarEstadoMaquina(id, nuevoEstado);
            return ResponseEntity.ok(maquina);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el estado de maquina: " + e.getMessage());
        }
    }
}
