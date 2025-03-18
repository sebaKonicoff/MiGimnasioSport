package com.migimnasio.sport.services;

import com.migimnasio.sport.dao.IPlanCarreraEjercicioDao;
import com.migimnasio.sport.data.PlanCarreraEjercicioRepository;
import com.migimnasio.sport.models.Ejercicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanCarreraEjercicioService {

    @Autowired
    private IPlanCarreraEjercicioDao repositoryDao;

    private static final Logger log = LoggerFactory.getLogger(PlanCarreraEjercicioService.class);

    public void insertarEjercicios(Long idPlanCarrera, List<Ejercicio> ejercicios){
        for(Ejercicio ejercicio : ejercicios){
            repositoryDao.insertarRegistro(idPlanCarrera, ejercicio.getIdEjercicio());
            log.info("Ejercicio insertado: {}", ejercicio.getIdEjercicio());
        }
    }
}
