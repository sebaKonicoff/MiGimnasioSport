package com.migimnasio.sport.services;

import com.migimnasio.sport.dao.IIntructorDao;
import com.migimnasio.sport.dao.IPlanDeCarreraDao;
import com.migimnasio.sport.data.PlanDeCarreraRepository;
import com.migimnasio.sport.dto.AlumnoDTO;
import com.migimnasio.sport.dto.InstructorDTO;
import com.migimnasio.sport.dto.PlanDeCarreraDTO;
import com.migimnasio.sport.dto.response.PlanDeCarreraResponseDTO;
import com.migimnasio.sport.exception.ResourceNotFoundException;
import com.migimnasio.sport.exception.ValidationException;
import com.migimnasio.sport.mappers.PlanDeCarreraMapper;
import com.migimnasio.sport.models.Alumno;
import com.migimnasio.sport.models.Ejercicio;
import com.migimnasio.sport.models.Instructor;
import com.migimnasio.sport.models.PlanDeCarrera;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private PlanDeCarreraMapper planDeCarreraMapper;

    private final IPlanDeCarreraDao iPlanDeCarreraDao;

    private static final Logger log = LoggerFactory.getLogger(PlanDeCarreraService.class);

    public PlanDeCarreraService(AlumnoService alumnoService, InstructorService instructorService, EjercicioService ejercicioService, PlanDeCarreraRepository planDeCarreraRepository, IIntructorDao iIntructorDao, IPlanDeCarreraDao iPlanDeCarreraDao) {
        this.alumnoService = alumnoService;
        this.instructorService = instructorService;
        this.ejercicioService = ejercicioService;
        this.planDeCarreraRepository = planDeCarreraRepository;
        this.iIntructorDao = iIntructorDao;
        this.iPlanDeCarreraDao = iPlanDeCarreraDao;
    }

    private PlanDeCarreraDTO toDTO(PlanDeCarrera planDeCarrera){
        return planDeCarreraMapper.toDTO(planDeCarrera);
    }

    private PlanDeCarrera toEntity(PlanDeCarreraDTO planDeCarreraDTO){
        return planDeCarreraMapper.toEntity(planDeCarreraDTO);
    }

    public PlanDeCarreraResponseDTO crearPlanDeCarrera(PlanDeCarreraDTO planDeCarreraDTO){
        try {
            log.info("Iniciando creación Plan de carrera");

            log.info("Se obtienen las entidades correspondientes para las validaciones.");
            Optional<PlanDeCarrera> planExistente = iPlanDeCarreraDao.existeByAlumnoAndEstado(planDeCarreraDTO.getIdAlumno());
            Alumno alumno = alumnoService.getEntityById(planDeCarreraDTO.getIdAlumno());

            Optional<Instructor> instructorExistente = iIntructorDao.existeInstructor(planDeCarreraDTO.getIdInstructor());
            Instructor instructor = instructorService.getEntityById(planDeCarreraDTO.getIdInstructor());

            List<Ejercicio> ejercicios = ejercicioService.getEjerciciosById(planDeCarreraDTO.getEjerciciosIds());


            validarPlanDeCarrera(planDeCarreraDTO, planExistente, instructorExistente, ejercicios);

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

            PlanDeCarrera savedPlanDeCarrera = planDeCarreraRepository.save(planDeCarrera);

            AlumnoDTO alumnoDTO = alumnoService.toDTO(alumno);
            InstructorDTO instructorDTO = instructorService.toDTO(instructor);
            List<Long> ejerciciosIds = ejercicios.stream()
                    .map(Ejercicio::getIdEjercicio)
                    .collect(Collectors.toList());

            return new PlanDeCarreraResponseDTO(
                    savedPlanDeCarrera.getIdPlanCarrera(),
                    alumnoDTO,
                    instructorDTO,
                    ejerciciosIds,
                    savedPlanDeCarrera.getMetaAlumno(),
                    savedPlanDeCarrera.getCantDiasXSemana(),
                    savedPlanDeCarrera.getFechaInicio(),
                    savedPlanDeCarrera.getFechaFin(),
                    savedPlanDeCarrera.getDescripcion(),
                    savedPlanDeCarrera.getEstado()
            );

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


    private void validarPlanDeCarrera(PlanDeCarreraDTO planDeCarreraDTO,
                                      Optional<PlanDeCarrera> planExistente,
                                      Optional<Instructor> instructorExistente,
                                      List<Ejercicio> ejercicios) {

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
}
