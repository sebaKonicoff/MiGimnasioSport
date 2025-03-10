package com.migimnasio.sport.dao;

import com.migimnasio.sport.enums.AlumnoEstado;
import com.migimnasio.sport.models.Alumno;

import java.util.List;

public interface IAlumnoDao{

    List<Alumno> alumnoXEstado(AlumnoEstado estadoAlumno);

    Alumno findByUserName(String userName);
}
