package com.migimnasio.sport.dao;

import org.springframework.stereotype.Component;


public interface IPlanCarreraEjercicioDao {

    void insertarRegistro(Long idPlanCarrera, Long idEjercicio);
}
