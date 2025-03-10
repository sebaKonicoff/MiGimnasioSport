package com.migimnasio.sport.dao;

import com.migimnasio.sport.enums.AlumnoEstado;
import com.migimnasio.sport.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAlumnoDao{

    List<Alumno> alumnoXEstado(AlumnoEstado estadoAlumno);
}
