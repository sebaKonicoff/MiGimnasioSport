package com.migimnasio.sport.controllers;

import com.migimnasio.sport.dto.InstructorDTO;
import com.migimnasio.sport.services.InstructorService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> crearInstructor(@RequestBody InstructorDTO instructorDTO, UriComponentsBuilder ucb){
        InstructorDTO responseDTO = instructorService.crearInstructor(instructorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public List<InstructorDTO> getAllInstructor(){
        return instructorService.getAllInstructor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(
            @PathVariable
            @Parameter(name = "id", description = "Id de instructor a buscar")
            Long id
    ){
            InstructorDTO instructorDTO = instructorService.findById(id);
            return ResponseEntity.ok(instructorDTO);
    }
}
