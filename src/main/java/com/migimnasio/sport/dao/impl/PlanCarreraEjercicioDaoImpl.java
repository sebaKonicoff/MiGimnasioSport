package com.migimnasio.sport.dao.impl;

import com.migimnasio.sport.dao.IPlanCarreraEjercicioDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class PlanCarreraEjercicioDaoImpl implements IPlanCarreraEjercicioDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertarRegistro(Long idPlanCarrera, Long idEjercicio) {
        entityManager.createNativeQuery("INSERT INTO plancarreraxejercicio(id_plan_carrera, id_ejercicio) VALUES (?1, ?2)")
                .setParameter(1, idPlanCarrera)
                .setParameter(2, idEjercicio)
                .executeUpdate();
    }
}
