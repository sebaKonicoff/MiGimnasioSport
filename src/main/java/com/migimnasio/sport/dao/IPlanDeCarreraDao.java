package com.migimnasio.sport.dao;

import com.migimnasio.sport.enums.PlanDeCarreraEstado;

public interface IPlanDeCarreraDao {

    boolean existeByAlumnoAndEstado(Long id, PlanDeCarreraEstado planDeCarreraEstado);
}
