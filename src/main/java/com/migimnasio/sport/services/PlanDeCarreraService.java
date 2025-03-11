package com.migimnasio.sport.services;

import com.migimnasio.sport.data.PlanDeCarreraRepository;
import com.migimnasio.sport.dto.PlanDeCarreraDTO;
import com.migimnasio.sport.exception.ValidationException;
import com.migimnasio.sport.models.Alumno;
import com.migimnasio.sport.models.Ejercicio;
import com.migimnasio.sport.models.Instructor;
import com.migimnasio.sport.models.PlanDeCarrera;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanDeCarreraService {

    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private EjercicioService ejercicioService;
    @Autowired
    private PlanDeCarreraRepository planDeCarreraRepository;

    private static final Logger log = LoggerFactory.getLogger(PlanDeCarreraService.class);

    public PlanDeCarrera crearPlanDeCarrera(PlanDeCarreraDTO planDeCarreraDTO){
        try {
            log.info("Iniciando creación Plan de carrera");
            if(planDeCarreraDTO.getFechaInicio().isAfter(planDeCarreraDTO.getFechaFin())){
                throw new ValidationException("La fecha inicio no puede ser posterior a la fecha fin");
            }
            log.info("Se obtienen las entidades correspondientes");
            Alumno alumno = alumnoService.getEntityById(planDeCarreraDTO.getIdAlumno());
            Instructor instructor = instructorService.getEntityById(planDeCarreraDTO.getIdInstructor());


            List<Ejercicio> ejercicios = ejercicioService.getEjerciciosById(planDeCarreraDTO.getEjerciciosIds());

            log.info("Se procede a crear Plan de Carrera");
            PlanDeCarrera planDeCarrera = new PlanDeCarrera();
            planDeCarrera.setAlumno(alumno);
            planDeCarrera.setInstructor(instructor);
            planDeCarrera.setEjercicios(ejercicios);
            planDeCarrera.setMetaAlumno(planDeCarreraDTO.getMetaAlumno());
            planDeCarrera.setCantDiasXSemana(planDeCarreraDTO.getCantDiasXSemana());
            planDeCarrera.setFechaInicio(planDeCarreraDTO.getFechaInicio());
            planDeCarrera.setFechaFin(planDeCarreraDTO.getFechaFin());
            planDeCarrera.setDescripcion(planDeCarreraDTO.getDescripcion());
            planDeCarrera.setEstado(planDeCarreraDTO.getEstado());

            log.info("Plan de carrera creado.");

            return planDeCarreraRepository.save(planDeCarrera);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
