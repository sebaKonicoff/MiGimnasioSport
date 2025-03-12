package com.migimnasio.sport.dao;

import com.migimnasio.sport.models.PlanDePago;

import java.util.Optional;

public interface IPlanDePagoDao {

    Optional<PlanDePago> existeEnCurso(Long id);
}
