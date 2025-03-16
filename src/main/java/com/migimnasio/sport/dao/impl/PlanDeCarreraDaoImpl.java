package com.migimnasio.sport.dao.impl;

import com.migimnasio.sport.dao.IPlanDeCarreraDao;
import com.migimnasio.sport.models.PlanDeCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlanDeCarreraDaoImpl implements IPlanDeCarreraDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<PlanDeCarrera> existeByAlumnoAndEstado(Long id) {
        String jpql = "SELECT p FROM PlanDeCarrera p WHERE p.alumno.idAlumno = :id_alumno " +
                "AND p.estado = 'CREADA'";

        try {
            return Optional.of(entityManager.createQuery(jpql, PlanDeCarrera.class)
                    .setParameter("id_alumno", id)
                    .getSingleResult());
        } catch (NoResultException e){
            return Optional.empty();
        }
    }
}
