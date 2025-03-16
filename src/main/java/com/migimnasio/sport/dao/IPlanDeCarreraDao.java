package com.migimnasio.sport.dao;

import com.migimnasio.sport.models.Ejercicio;
import com.migimnasio.sport.models.PlanDeCarrera;

import java.util.List;
import java.util.Optional;

public interface IPlanDeCarreraDao {

    Optional<PlanDeCarrera> existeByAlumnoAndEstado(Long id);

}
