package com.migimnasio.sport.dao.impl;

import com.migimnasio.sport.dao.IPlanDePagoDao;
import com.migimnasio.sport.models.PlanDePago;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlanDePagoDaoImpl implements IPlanDePagoDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<PlanDePago> existeEnCurso(Long id) {
        String jpql = "SELECT pp FROM PlanDePago pp WHERE pp.alumno.id = :id " +
                "AND planPagoEstado = 'EN_CURSO'";

        try {
            return Optional.of(entityManager.createQuery(jpql, PlanDePago.class)
                    .setParameter("id", id)
                    .getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
}
