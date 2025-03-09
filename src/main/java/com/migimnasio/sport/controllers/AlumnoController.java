package com.migimnasio.sport.controllers;

import com.migimnasio.sport.models.Alumno;
import com.migimnasio.sport.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno newAlumno, UriComponentsBuilder ucb){
        Alumno alumno = alumnoService.crearAlumno(newAlumno);
        URI uriAlumno = ucb.path("/api/alumnos/{id}").buildAndExpand(alumno.getIdAlumno()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(uriAlumno).body(alumno);
    }
}
