package com.migimnasio.sport.services;

import com.migimnasio.sport.dao.IPlanDePagoDao;
import com.migimnasio.sport.data.PlanDePagoRepository;
import com.migimnasio.sport.dto.AlumnoDTO;
import com.migimnasio.sport.dto.PlanDePagoDTO;
import com.migimnasio.sport.dto.response.PlanDePagoResponseDTO;
import com.migimnasio.sport.enums.PlanPagoEstado;
import com.migimnasio.sport.exception.ResourceNotFoundException;
import com.migimnasio.sport.exception.ValidationException;
import com.migimnasio.sport.mappers.PlanDePagoMapper;
import com.migimnasio.sport.models.Alumno;
import com.migimnasio.sport.models.PlanDePago;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanDePagoService {

    private final AlumnoService alumnoService;
    private final PlanDePagoRepository planDePagoRepository;
    private final IPlanDePagoDao iPlanDePagoDao;
    private final PlanDePagoMapper planDePagoMapper;

    private static final Logger log = LoggerFactory.getLogger(PlanDePagoService.class);

    public PlanDePagoService(AlumnoService alumnoService, PlanDePagoRepository planDePagoRepository, IPlanDePagoDao iPlanDePagoDao, PlanDePagoMapper planDePagoMapper) {
        this.alumnoService = alumnoService;
        this.planDePagoRepository = planDePagoRepository;
        this.iPlanDePagoDao = iPlanDePagoDao;
        this.planDePagoMapper = planDePagoMapper;
    }

    public PlanDePagoResponseDTO toResponseDTO(PlanDePago planDePago){
        return planDePagoMapper.toResponseDTO(planDePago);
    }

    public PlanDePagoResponseDTO crearPlanDePago(PlanDePagoDTO planDePagoDTO){
        try {
            Alumno alumno = alumnoService.getEntityById(planDePagoDTO.getIdAlumno());

            validarPlanDePago(planDePagoDTO);

            PlanDePago planDePago = new PlanDePago();
            planDePago.setAlumno(alumno);
            planDePago.setTipoPlanPago(planDePagoDTO.getTipoPlanPago());
            planDePago.setPlanPagoEstado(planDePagoDTO.getPlanPagoEstado());
            planDePago.setMontoTotal(planDePagoDTO.getMontoTotal());
            planDePago.setFechaInicio(planDePagoDTO.getFechaInicio());
            planDePago.setFechaFin(planDePagoDTO.getFechaFin());
            planDePago.setNroCuotas(planDePagoDTO.getNroCuotas());

            PlanDePago savedPlanDePago = planDePagoRepository.save(planDePago);

            AlumnoDTO alumnoDTO = alumnoService.toDTO(alumno);

            return crearEntidadResponseDTO(savedPlanDePago, alumnoDTO);

        } catch (ValidationException ex){
            log.error("Error de validacion. " + ex.getMessage());
            throw ex;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PlanDePagoResponseDTO actualizarPlanDePago(long id, PlanPagoEstado planPagoEstado){
        PlanDePago planDePago = getEntityById(id);
        planDePago.setPlanPagoEstado(planPagoEstado);
        planDePagoRepository.save(planDePago);
        AlumnoDTO alumnoDTO = alumnoService.toDTO(
                alumnoService.getEntityById(planDePago.getAlumno().getIdAlumno())
        );

        return crearEntidadResponseDTO(planDePago, alumnoDTO);
    }

    public PlanDePago getEntityById(long id){
        return planDePagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró Plan de Pago."));
    }

    private PlanDePagoResponseDTO crearEntidadResponseDTO(PlanDePago planDePago, AlumnoDTO alumnoDTO){
        return new PlanDePagoResponseDTO(
                planDePago.getIdPlanPago(),
                alumnoDTO,
                planDePago.getTipoPlanPago(),
                planDePago.getPlanPagoEstado(),
                planDePago.getMontoTotal(),
                planDePago.getFechaInicio(),
                planDePago.getFechaFin(),
                planDePago.getNroCuotas()
        );
    }

    public void validarPlanDePago(PlanDePagoDTO planDePagoDTO){
        log.info("Iniciando validaciones para creacion de plan de pago");

        if(planDePagoDTO.getFechaInicio().isAfter(planDePagoDTO.getFechaFin())){
            throw new ValidationException("La fecha inicio no puede ser posterior a fecha fin.");
        }

        Optional<PlanDePago> planDePagoEnCurso = iPlanDePagoDao.existeEnCurso(planDePagoDTO.getIdAlumno());
        if (planDePagoEnCurso.isPresent()){
            throw new ValidationException(
                    "El alumno con id: " + planDePagoDTO.getIdAlumno() + " " +
                            "ya tiene un plan de pago en curso."
            );
        }

        log.info("Validaciones completadas exitosamente.");
    }
}
