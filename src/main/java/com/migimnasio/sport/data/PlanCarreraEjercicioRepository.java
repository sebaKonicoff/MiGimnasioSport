package com.migimnasio.sport.data;

import com.migimnasio.sport.models.PlanCarreraEjercicio;
import com.migimnasio.sport.models.pk.PlanCarreraEjercicioPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanCarreraEjercicioRepository extends JpaRepository<PlanCarreraEjercicio, PlanCarreraEjercicioPK> {
}
