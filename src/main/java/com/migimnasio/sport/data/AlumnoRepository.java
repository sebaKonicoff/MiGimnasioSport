package com.migimnasio.sport.data;

import com.migimnasio.sport.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "alumnos")
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
