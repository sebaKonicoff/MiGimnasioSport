package com.migimnasio.sport.services;

import com.migimnasio.sport.dao.IPlanDePagoDao;
import com.migimnasio.sport.data.PlanDePagoRepository;
import com.migimnasio.sport.dto.PlanDePagoDTO;
import com.migimnasio.sport.exception.ValidationException;
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

    private static final Logger log = LoggerFactory.getLogger(PlanDePagoService.class);

    public PlanDePagoService(AlumnoService alumnoService, PlanDePagoRepository planDePagoRepository, IPlanDePagoDao iPlanDePagoDao) {
        this.alumnoService = alumnoService;
        this.planDePagoRepository = planDePagoRepository;
        this.iPlanDePagoDao = iPlanDePagoDao;
    }

    public PlanDePago crearPlanDePago(PlanDePagoDTO planDePagoDTO){
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

            return planDePagoRepository.save(planDePago);
        } catch (ValidationException ex){
            log.error("Error de validacion. " + ex.getMessage());
            throw ex;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
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
