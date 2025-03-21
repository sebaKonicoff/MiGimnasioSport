package com.migimnasio.sport.controllers;

import com.migimnasio.sport.dto.AlumnoDTO;
import com.migimnasio.sport.enums.AlumnoEstado;
import com.migimnasio.sport.services.AlumnoService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<AlumnoDTO> crearAlumno(@RequestBody AlumnoDTO alumnoDTO, UriComponentsBuilder ucb){
        AlumnoDTO responseDTO = alumnoService.crearAlumno(alumnoDTO);
        URI uriAlumno = ucb.path("/api/alumnos/{id}").buildAndExpand(responseDTO.getIdAlumno()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public List<AlumnoDTO> getAllAlumnos(){
        return alumnoService.getAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(
            @PathVariable
            @Parameter(name = "id", description = "Id de alumno a buscar")
            Long id
    ){
            AlumnoDTO alumnoDTO = alumnoService.findById(id);
            return ResponseEntity.ok(alumnoDTO);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstadoAlumno(@PathVariable long id, @RequestParam AlumnoEstado nuevoEstado){
            AlumnoDTO alumnoDTO = alumnoService.actualizarEstado(id, nuevoEstado);
            return ResponseEntity.ok(alumnoDTO);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<AlumnoDTO>> buscarAlumnosPorEstado(
            @RequestParam AlumnoEstado estado
    ){
        List<AlumnoDTO> alumnoDTOS = alumnoService.buscarAlumnosPorEstado(estado);
        return ResponseEntity.ok(alumnoDTOS);
    }
}