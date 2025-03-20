package com.migimnasio.sport.services;

import com.migimnasio.sport.dao.IIntructorDao;
import com.migimnasio.sport.dao.IPlanCarreraEjercicioDao;
import com.migimnasio.sport.dao.IPlanDeCarreraDao;
import com.migimnasio.sport.data.PlanDeCarreraRepository;
import com.migimnasio.sport.dto.AlumnoDTO;
import com.migimnasio.sport.dto.InstructorDTO;
import com.migimnasio.sport.dto.PlanDeCarreraDTO;
import com.migimnasio.sport.dto.response.PlanDeCarreraResponseDTO;
import com.migimnasio.sport.enums.PlanDeCarreraEstado;
import com.migimnasio.sport.exception.ResourceNotFoundException;
import com.migimnasio.sport.exception.ValidationException;
import com.migimnasio.sport.mappers.PlanDeCarreraMapper;
import com.migimnasio.sport.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanDeCarreraService {

    private final AlumnoService alumnoService;
    private final InstructorService instructorService;
    private final EjercicioService ejercicioService;
    private final PlanDeCarreraRepository planDeCarreraRepository;
    private final IIntructorDao iIntructorDao;

    private final PlanCarreraEjercicioService planCEjercicioService;

    private PlanDeCarreraMapper planDeCarreraMapper;

    private final IPlanDeCarreraDao iPlanDeCarreraDao;

    private static final Logger log = LoggerFactory.getLogger(PlanDeCarreraService.class);

    public PlanDeCarreraService(AlumnoService alumnoService, InstructorService instructorService, EjercicioService ejercicioService, PlanDeCarreraRepository planDeCarreraRepository, IIntructorDao iIntructorDao, PlanCarreraEjercicioService planCEjercicioService, IPlanDeCarreraDao iPlanDeCarreraDao) {
        this.alumnoService = alumnoService;
        this.instructorService = instructorService;
        this.ejercicioService = ejercicioService;
        this.planDeCarreraRepository = planDeCarreraRepository;
        this.iIntructorDao = iIntructorDao;
        this.planCEjercicioService = planCEjercicioService;
        this.iPlanDeCarreraDao = iPlanDeCarreraDao;
    }

    private PlanDeCarreraDTO toDTO(PlanDeCarrera planDeCarrera){
        return planDeCarreraMapper.toDTO(planDeCarrera);
    }

    private PlanDeCarrera toEntity(PlanDeCarreraDTO planDeCarreraDTO){
        return planDeCarreraMapper.toEntity(planDeCarreraDTO);
    }

    private PlanDeCarrera getEntity(Long id){
        return planDeCarreraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se econtró Plan de Carrera."));
    }

    public PlanDeCarreraResponseDTO crearPlanDeCarrera(PlanDeCarreraDTO planDeCarreraDTO){
        try {
            log.info("Iniciando creación Plan de carrera");

            List<Ejercicio> ejercicios = ejercicioService.getEjerciciosById(planDeCarreraDTO.getEjerciciosIds());
            validarPlanDeCarrera(planDeCarreraDTO, ejercicios);

            Alumno alumno = alumnoService.getEntityById(planDeCarreraDTO.getIdAlumno());
            Instructor instructor = instructorService.getEntityById(planDeCarreraDTO.getIdInstructor());

            //Se crea el plan de carrera
            PlanDeCarrera planDeCarrera = crearEntidadPlanDeCarrera(planDeCarreraDTO, alumno, instructor, ejercicios);

            PlanDeCarrera savedPlanDeCarrera = planDeCarreraRepository.save(planDeCarrera);

            log.info("Se procede a insertar los ejercicios en tabla");
            planCEjercicioService.insertarEjercicios(planDeCarrera.getIdPlanCarrera(), ejercicios);
            log.info("Ejercicios insertados");

            AlumnoDTO alumnoDTO = alumnoService.toDTO(alumno);
            InstructorDTO instructorDTO = instructorService.toDTO(instructor);
            List<Long> ejerciciosIds = ejercicios.stream()
                    .map(Ejercicio::getIdEjercicio)
                    .collect(Collectors.toList());

            return crearEntidadResponseDTO(savedPlanDeCarrera, alumnoDTO, instructorDTO, ejerciciosIds);

        }catch (ResourceNotFoundException ex){
            log.error("No se encontró recurso. " + ex.getMessage());
            throw ex;
        }
        catch (ValidationException ex){
            log.error("Error de validación. " + ex.getMessage());
            throw ex;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PlanDeCarrera actualizarEstado(Long id, PlanDeCarreraEstado estado){
        PlanDeCarrera planDeCarrera = getEntity(id);
        planDeCarrera.setEstado(estado);
        planDeCarreraRepository.save(planDeCarrera);
        return planDeCarrera;
    }

    private void validarPlanDeCarrera(PlanDeCarreraDTO planDeCarreraDTO, List<Ejercicio> ejercicios) {

        log.info("Se obtienen las entidades correspondientes para las validaciones.");

        Optional<PlanDeCarrera> planExistente = iPlanDeCarreraDao.existeByAlumnoAndEstado(planDeCarreraDTO.getIdAlumno());

        Optional<Instructor> instructorExistente = iIntructorDao.existeInstructor(planDeCarreraDTO.getIdInstructor());

        log.info("Iniciando validaciones para la creación del Plan de Carrera");

        // Validar fechas de inicio y fin
        if (planDeCarreraDTO.getFechaInicio().isAfter(planDeCarreraDTO.getFechaFin())) {
            throw new ValidationException("La fecha inicio no puede ser posterior a la fecha fin");
        }

        // Validar si el alumno ya tiene un plan de carrera en curso
        if (planExistente.isPresent()) {
            throw new ValidationException(
                    "El alumno con id: " + planDeCarreraDTO.getIdAlumno() +
                            " ya tiene un Plan de Carrera en curso."
            );
        }

        // Validar instructor habilitado
        if (instructorExistente.isPresent()) {
            throw new ValidationException(
                    "El instructor con id: " + planDeCarreraDTO.getIdInstructor() +
                            " no está habilitado."
            );
        }

        // Validar lista de ejercicios no vacía
        if (ejercicios.isEmpty()) {
            throw new ResolutionException("Ejercicios no encontrados.");
        }

        log.info("Validaciones del Plan de Carrera completadas exitosamente");
    }

    private PlanDeCarreraResponseDTO crearEntidadResponseDTO(PlanDeCarrera planDeCarrera, AlumnoDTO alumnoDTO, InstructorDTO instructorDTO, List<Long> ejerciciosIds){
        return new PlanDeCarreraResponseDTO(
                planDeCarrera.getIdPlanCarrera(),
                alumnoDTO,
                instructorDTO,
                ejerciciosIds,
                planDeCarrera.getMetaAlumno(),
                planDeCarrera.getCantDiasXSemana(),
                planDeCarrera.getFechaInicio(),
                planDeCarrera.getFechaFin(),
                planDeCarrera.getDescripcion(),
                planDeCarrera.getEstado()
        );
    }

    private PlanDeCarrera crearEntidadPlanDeCarrera(PlanDeCarreraDTO planDeCarreraDTO, Alumno alumno, Instructor instructor, List<Ejercicio> ejercicios){
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

        return planDeCarrera;
    }
}
