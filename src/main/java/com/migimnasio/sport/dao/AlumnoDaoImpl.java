package com.migimnasio.sport.dao;

import com.migimnasio.sport.enums.AlumnoEstado;
import com.migimnasio.sport.models.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlumnoDaoImpl implements IAlumnoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Alumno> alumnoXEstado(AlumnoEstado estadoAlumno) {
        String jpql = "SELECT a FROM Alumno a WHERE a.estado = :estado";

        List<Alumno> alumnos = entityManager.createQuery(jpql, Alumno.class)
                .setParameter("estado", estadoAlumno)
                .getResultList();

        return alumnos;
    }
}
