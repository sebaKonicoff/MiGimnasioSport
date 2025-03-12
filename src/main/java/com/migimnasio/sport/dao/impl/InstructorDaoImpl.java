package com.migimnasio.sport.dao.impl;

import com.migimnasio.sport.dao.IIntructorDao;
import com.migimnasio.sport.models.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InstructorDaoImpl implements IIntructorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Instructor> existeInstructor(Long id) {
        String jpql = "SELECT i FROM Instructor i WHERE i.idInstructor = :id " +
                "AND i.estado = 'DE_BAJA'";

        try {
            return Optional.of(entityManager.createQuery(jpql, Instructor.class)
                    .setParameter("id", id)
                    .getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
}
